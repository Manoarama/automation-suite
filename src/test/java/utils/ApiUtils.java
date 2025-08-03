package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    static {
        RestAssured.baseURI = "https://reqres.in/api"; // Sample public API
    }

    public static Response get(String endpoint) {
        return RestAssured
                .given()
                .log().all()
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint, String body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .log().all()
                .when()
                .post(endpoint);
    }

    // Add PUT, DELETE, PATCH as needed

}
