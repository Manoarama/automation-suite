package question.example.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIUser {
/* Scenario: Test a typical POST/GET API flow using REST Assured or Java pseudocode.
   Task:1.	Send a POST request to create a user (/users)
    o	Body: { "name": "John", "email": "john@test.com" }
    2.	Assert status = 201
    3.	Extract the userId from the response
    4.	Send a GET request to /users/{userId}
    5.	Assert returned email = "john@test.com"*/


    public static void main(String[] args) {

        // 1. Set base URI (Change as per your API)
        RestAssured.baseURI = "https://reqres.in/api"; // Sample mock API

        // 2. Send POST request to create a user
        Response postResponse = given()
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"John\", \"email\": \"john@test.com\" }")
                .when()
                .post("/users")
                .then()
                .assertThat().statusCode(201)
                .extract().response();

        // 3. Extract userId from the response (assuming 'id' field returned)
        String userId = postResponse.jsonPath().getString("id");
        System.out.println("Created userId: " + userId);

        // 4. Send GET request using userId
        Response getResponse = given()
                .when()
                .get("/users/" + userId)
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        // 5. Assert the returned email
        String returnedEmail = getResponse.jsonPath().getString("data.email");
        System.out.println("Returned Email: " + returnedEmail);
        assert returnedEmail.equals("john@test.com") : "Email mismatch!";
    }
}
