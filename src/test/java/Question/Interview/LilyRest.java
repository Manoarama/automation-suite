package Question.Interview;

import io.restassured.response.Response;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

import static io.restassured.RestAssured.given;

public class LilyRest {



    public static void main(String[] args) {
        // 🔐 Disable SSL validation (only for dev use)
        String endpoint = "https://jsonplaceholder.typicode.com/users/1"; // sample API
        int maxRetries = 3;
        Response response = null;

        for (int i = 1; i <= maxRetries; i++) {
            try {
                response = given()
                        .when()
                        .get(endpoint)
                        .then()
                        .statusCode(200) // ✅ Assert status code
                        .extract().response();

                System.out.println("Response received on attempt " + i);
                break;

            } catch (AssertionError | Exception e) {
                System.out.println("Attempt " + i + " failed: " + e.getMessage());
                if (i == maxRetries) {
                    System.out.println("Max retries reached. Exiting...");
                    return;
                }
            }
        }

        // ✅ Further response validation
        if (response != null) {
            String email = response.jsonPath().getString("email");
            System.out.println("Email in response: " + email);

            if ("Sincere@april.biz".equals(email)) {
                System.out.println("Email validation passed");
            } else {
                System.out.println("Email validation failed");
            }
        }
    }
}


