package Question.Session13;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

// Retrieve query/request specification
public class QueryRequestSpecification {
    @Test
    public void createUser(){
        //create json data
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Rekha");
        jsonObject.put("job", "QA1");

        //create request specification
        RequestSpecification requestSpecification= RestAssured.given();

        //specify URL
        requestSpecification.baseUri("https://reqres.in/")
        .basePath("/api/users")
                .contentType(ContentType.JSON.toString())
                .body(jsonObject);

//query details from request specification
   QueryableRequestSpecification queryableRequestSpecification= SpecificationQuerier.query(requestSpecification);
//get base URi

        String retriveBaseURI=queryableRequestSpecification.getBaseUri();
        System.out.println( "Base"+retriveBaseURI);

        String retriveBasepath=queryableRequestSpecification.getBasePath();
        System.out.println( "Base"+retriveBasepath);

        //getBody
        String retriveBaseBody=queryableRequestSpecification.getBody();
        System.out.println( "retriveBaseBody"+retriveBaseBody);

        Headers header=queryableRequestSpecification.getHeaders();

        for(Header h:header){
        System.out.println( "header : "+h.getName()+h.getValue());
    }

}}
