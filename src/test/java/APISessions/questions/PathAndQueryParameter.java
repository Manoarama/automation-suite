package APISessions.questions;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameter {
    @Test
    void testPathAndQueryParameter(){
        RestAssured.useRelaxedHTTPSValidation();

        //https://reqres.in/api/users?page=2
        given()
                .pathParams("mypath","users")
                .queryParams("page",2)
                //.queryParams("id",7)
        .when()
                .get("https://reqres.in/api/{mypath}")
        .then()
                .statusCode(200)
                .log().all();
    }
}
