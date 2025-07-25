package Question.Interview;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerToken {

    public static void main(String[] args) {
        String baseUri = "https://api.example.com";
        String endpoint = "/secured/data";
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."; // your token

        Response response = RestAssured
                .given()
                .baseUri(baseUri)
                .header("Authorization", "Bearer " + bearerToken)
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)  // validate status
                .extract().response();

        System.out.println("Response:\n" + response.asPrettyString());
    }
}

