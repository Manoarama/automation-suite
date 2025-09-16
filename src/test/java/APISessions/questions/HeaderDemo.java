package APISessions.questions;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeaderDemo {

 //   @Test(priority=1)
    void testHeader(){
        RestAssured.useRelaxedHTTPSValidation();
        //https://reqres.in/api/users?page=2
        given()
        .when()
                .get("https://google.com/")
        .then()
                .header("Content-Type","\t\n" +
                        "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .header("Server","gws")
                .log().all();
    }

  @Test(priority=2)
    void getCookiesInfo(){
        RestAssured.useRelaxedHTTPSValidation();
        //https://reqres.in/api/users?page=2
        Response response=given()
                .when()
                    .get("https://google.com/");

//get Single header info
      String headerValue =response.getHeader("Content-Type");
        System.out.println("Value of the Header is :"+ headerValue);
    //get all cookies value

        Headers myHeadersValues =response.getHeaders();

            for(Header header: myHeadersValues){
             String headervalue=header.getValue();
                header.getName();
                System.out.println(headervalue =" : "+ header.getName());

         }
    }
}
