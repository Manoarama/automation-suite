package Question.session12;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

public class DeserializationDemo {

   @Test
    public void createUser(){
        RestAssured.useRelaxedHTTPSValidation();

        RequestSpecification requestSpecification= RestAssured.given().header("x-api-key","reqres-free-v1");
        //specify URL
        requestSpecification.baseUri("https://reqres.in/");
        requestSpecification.basePath("/api/users");

        //create json body
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","Manorama1");
        jsonObject.put("job","QA");

        //perform post request
        Response response=requestSpecification.contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .post();


        // Check response status before deserializing
        Assert.assertEquals(response.getStatusCode(), 201, "Status Code should be 201 for successful creation");


        //ResponseBody responseBody=response.getBody();

        //Deserialize response body ie json response body to class object

        JsonPostRequestResponse responseData =response.getBody().as(JsonPostRequestResponse.class);
        Assert.assertEquals(responseData .name,"Manorama1","Check for name");
        Assert.assertEquals(responseData .job,"QA","Check for job");

        // Optionally print the response
        System.out.println("ID: " + responseData.id);
        System.out.println("CreatedAt: " + responseData.createdAt);
    }
    @Test
    public void createUser1(){
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/users";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Manorama1");
        jsonObject.put("job", "QA1");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .post();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 201, "Status Code should be 201 for successful creation");

        JsonPostRequestResponse responseData = response.as(JsonPostRequestResponse.class);
        Assert.assertEquals(responseData.name, "Manorama1", "Check for name");
        Assert.assertEquals(responseData.job, "QA1", "Check for job");
    }
}
