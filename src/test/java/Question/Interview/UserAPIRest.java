package Question.Interview;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
public class UserAPIRest {
        @Test
        public void createAndGetUser() {
            // Base URI
            RestAssured.baseURI = "https://your-api-base-url.com";
            // replace with real base URL

            // Step 1: Send POST request to create user
            Response postResponse = given()
                    .header("Content-Type", "application/json")
                    .body("{ \"name\": \"John\", \"email\": \"john@test.com\" }")
                    .when()
                    .post("/users");

            // Step 2: Assert status = 201
            assertEquals(postResponse.getStatusCode(), 201, "Expected status code 201");

            // Step 3: Extract userId from response
            int userId = postResponse.jsonPath().getInt("id");
            System.out.println("Created userId: " + userId);

            // Step 4: Send GET request to /users/{userId}
            Response getResponse = given()
                    .when()
                    .get("/users/" + userId);

            // Step 5: Assert returned email = "john@test.com"
            String returnedEmail = getResponse.jsonPath().getString("email");
            assertEquals(returnedEmail, "john@test.com", "Email did not match expected value");
        }
    }



