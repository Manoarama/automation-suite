package restassuredFramework.utils;

import io.restassured.response.Response;

import java.util.function.Supplier;

public class RetryExecutor {

    private static final int MAX_RETRIES = 3;

    public static Response execute(Supplier<Response> action) {
        int attempt = 0;
        while (attempt < MAX_RETRIES) {
            try {
                Response response = action.get();
                if (response.getStatusCode() < 500) {
                    return response;
                }
            } catch (Exception ignored) {}
            attempt++;
        }
        throw new RuntimeException("API failed after retries");
    }
}

