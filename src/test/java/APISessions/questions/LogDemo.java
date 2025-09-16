package APISessions.questions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogDemo {

    @Test(priority = 1)
    void getLogInfo() {
        RestAssured.useRelaxedHTTPSValidation();
        //https://reqres.in/api/users?page=2
       given()
                .when()
                .get("https://google.com/")
                .then()
                        .log().all()
                        .log().body()
                        .log().cookies();
    }
}