package APISessions.questions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CokiesDemo {

    //@Test(priority=1)
    void testCookies(){
        RestAssured.useRelaxedHTTPSValidation();
        //https://reqres.in/api/users?page=2
        given()
        .when()
                .get("https://google.com/")
        .then()
                .cookie("ACE","")
                .log().all();
    }

    @Test(priority=2)
    void getCookiesInfo(){
        RestAssured.useRelaxedHTTPSValidation();
        //https://reqres.in/api/users?page=2
        Response response=given()
                .when()
                    .get("https://google.com/");
//get Single cookie info
      String cookieValue=response.getCookie("AEC");
        System.out.println("Value of the cookie is :"+cookieValue);
    //get all cookies value

        Map<String, String> cookiesValues=response.getCookies();
            cookiesValues.keySet();
            for(String key: cookiesValues.keySet()){
             String cookiesValue=response.getCookie(key);
             System.out.println(key+":"+cookiesValue);
         }
    }
}
