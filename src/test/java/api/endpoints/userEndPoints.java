package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.rootPath;

public class userEndPoints {


    public static Response createUser(User payload){
        Response response=given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postUrl);

        return response;


    }
    public static Response getUser(String userName){
        Response response=given().accept(ContentType.JSON)
                .pathParams("username",userName)
                .when()
                .get(Routes.getUrl);

        return response;


    }
    public static Response updateUser(String userName,User payload){
        Response response=given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParams("username",userName)
                .body(payload)
                .when()
                .put(Routes.putUrl);

        return response;


    }


    public static Response deleteUser(String userName){
        Response response=given().accept(ContentType.JSON)

                .pathParams("username",userName)

                .when()
                .delete(Routes.deleteUrl);

        return response;


    }
}
