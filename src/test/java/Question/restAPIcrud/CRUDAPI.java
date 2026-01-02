package Question.restAPIcrud;

import Question.Interview.RetryAnalyzer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CRUDAPI {
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
@Test
    public void updateUserTest(){
       UserRequest userRequest=new UserRequest("Manorama","john123","john@test.com");
       UserResponse response=
               given()
                       .contentType("application/json")
                       .body(userRequest)
               .when()
                       .put("/users/1")
                .then()
                       .statusCode(200)
                       .extract().as(UserResponse.class);
       Assert.assertEquals(response.getName(),"Manorama");

}
    @Test
    public void deleteUserTest(){
       given()
               .when()
               .delete("users/1")
               .then()
               .statusCode(200);
    }



    /* public static void main(String[] args) {
      *//* System.out.println("Try programiz.pro");
       String name="Manorama";
       HashMap<Character,Integer> map=new HashMap();
       for (Character c:name.toCharArray()){
           if(map.containsKey(c))
               map.put(c,map.get(c)+1);
           else
               map.put(c,1);
       }
       System.out.println(map);*//*
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
