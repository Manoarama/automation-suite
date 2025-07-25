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

        RequestSpecification requestSpecification= RestAssured.given();
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
        Assert.assertEquals(responseData .name,"Manorama","Check for name");
        Assert.assertEquals(responseData .job,"QA","Check for job");

        // Optionally print the response
        System.out.println("ID: " + responseData.id);
        System.out.println("CreatedAt: " + responseData.createdAt);
    }
}
