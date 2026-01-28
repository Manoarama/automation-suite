package Question.Interview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
class UserRequest {
    private String name;
    private String username;
    private String email;
    public UserRequest(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class UserResponse {
    private int id;
    private String name;
    private String username;
    private String email;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
}
public class RetryAnalyzer implements IRetryAnalyzer {
    private int count=0;
    private static final int MAX_RETRY=2;
    public RetryAnalyzer() {
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<MAX_RETRY){
            count++;
            return true;
        }
        return false;
    }
}

 class CRUDAPI {
    // ---------------- BASE SETUP ----------------
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; // Public dummy API
        //https://reqres.in/api/users
    }
    @Test
    public void getUserTest(){
    Response response=
            given()
                    .queryParam("_page",1)
                    .queryParam("_limit",5)
             .when()
                    .get("/users")
             .then()
                   .statusCode(200).extract().response();
     List<?> user =response.jsonPath().getList("",UserResponse.class);
     Assert.assertEquals(user.size(),5);
     System.out.println("User Size"+user.size());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createUserTest(){
        UserRequest request=new UserRequest("John Doe","john123","john@test.com");

        UserResponse response=
              given()
                 .contentType("application/json")
                 .body(request)
              .when()
                 .post("/users")
              .then()
                 .statusCode(201)
                 .extract().as(UserResponse.class);
        Assert.assertEquals(response.getName(),"John Doe");
}

   /*
        String baseURI="https://automationexercise.com/api/productsList";
//No serialization needed (no request body)
       given()
               .when().get(baseURI).then().statusCode(200);
        Response response =given()
                .when().get(baseURI).then().statusCode(200).extract().response();

//POST – Serialization + Deserialization
        UserRequest request = new UserRequest("Manorama","");
        UserResponse respons=given()
                .contentType(ContentType.JSON)
                .body(request)//// ✅ SERIALIZATION
                .when().post("/users")
                .then().statusCode(201).extract()
                .as(UserResponse.class);//// ✅ DESERIALIZATION
        int userID=respons.getId();

        //PUT – Serialization
        UserRequest updaterequest=new UserRequest("Manorama Singh","");
        given()
                .contentType(ContentType.JSON)
                .body(updaterequest)
        .when().put("\"/users/\" + userId").then().statusCode(200);
}
*/

    }
