package retry;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Duration;
import java.util.Map;
import java.util.Random;

public class ResilientHttp {

    private final int maxRetries;
    private final Duration baseDelay;
    private final Duration maxDelay;
    private final Random rnd = new Random();

    public ResilientHttp(int maxRetries, Duration baseDelay, Duration maxDelay) {
        this.maxRetries = maxRetries;
        this.baseDelay = baseDelay;
        this.maxDelay = maxDelay;
    }

    /** Public method: GET with retry */
    public Response getWithRetry(String url, Map<String, ?> queryParams, Map<String, String> headers) {
        Response last = null;
        for (int attempt = 0; attempt <= maxRetries; attempt++) {
            last = RestAssured
                    .given()
                    .headers(headers != null ? headers : Map.of())
                    .queryParams(queryParams != null ? queryParams : Map.of())
                    .accept(ContentType.JSON)
                    .when()
                    .get(url)
                    .then()
                    .extract().response();

            if (!shouldRetry(last)) return last;
            backoffWithJitter(attempt, parseRetryAfter(last));
        }
        return last;
    }

    /** Public method: POST with idempotency key + retry */
    public Response postWithRetryIdempotent(String url, Object body, String idempotencyKey, Map<String, String> headers) {
        Response last = null;
        for (int attempt = 0; attempt <= maxRetries; attempt++) {
            last = RestAssured
                    .given()
                    .headers(headers != null ? headers : Map.of())
                    .header("Idempotency-Key", idempotencyKey)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(url)
                    .then()
                    .extract().response();

            if (!shouldRetry(last)) return last;
            backoffWithJitter(attempt, parseRetryAfter(last));
        }
        return last;
    }

    /** Public method: PUT with retry (idempotent by semantics) */
    public Response putWithRetry(String url, Object body, Map<String, String> headers) {
        Response last = null;
        for (int attempt = 0; attempt <= maxRetries; attempt++) {
            last = RestAssured
                    .given()
                    .headers(headers != null ? headers : Map.of())
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(body)
                    .when()
                    .put(url)
                    .then()
                    .extract().response();

            if (!shouldRetry(last)) return last;
            backoffWithJitter(attempt, parseRetryAfter(last));
        }
        return last;
    }

    /** Decide if we should retry based on HTTP status */
    private boolean shouldRetry(Response r) {
        int s = r.statusCode();
        return s == 429 || s == 500 || s == 502 || s == 503 || s == 504;
    }

    /** Respect numeric Retry-After header (seconds). */
    private Long parseRetryAfter(Response r) {
        String h = r.getHeader("Retry-After");
        if (h == null || h.isBlank()) return null;
        try {
            return Long.parseLong(h.trim());
        } catch (NumberFormatException e) {
            // For date format, you could parse RFC 7231 date. Keeping simple here.
            return null;
        }
    }

    /** Exponential backoff with full jitter. */
    private void backoffWithJitter(int attempt, Long retryAfterSeconds) {
        try {
            if (retryAfterSeconds != null && retryAfterSeconds > 0) {
                Thread.sleep(retryAfterSeconds * 1000L);
                return;
            }
            long cap = maxDelay.toMillis();
            long exp = (long) (baseDelay.toMillis() * Math.pow(2, attempt));
            long upperBound = Math.min(exp, cap);
            long sleepMs = (upperBound <= 0) ? baseDelay.toMillis() : (long) (rnd.nextDouble() * upperBound);
            Thread.sleep(sleepMs);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}


