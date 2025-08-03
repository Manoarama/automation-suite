package Question.Session14;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ValidateXMLResponse {
    @Test
    public void addPet(){
        RestAssured.useRelaxedHTTPSValidation();
        String xmlObject="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Pet>\n" +
                "\t<id>0</id>\n" +
                "\t<Category>\n" +
                "\t\t<id>0</id>\n" +
                "\t\t<name>string</name>\n" +
                "\t</Category>\n" +
                "\t<name>doggie</name>\n" +
                "\t<photoUrls>\n" +
                "\t\t<photoUrl>string</photoUrl>\n" +
                "\t</photoUrls>\n" +
                "\t<tags>\n" +
                "\t\t<Tag>\n" +
                "\t\t\t<id>0</id>\n" +
                "\t\t\t<name>string</name>\n" +
                "\t\t</Tag>\n" +
                "\t</tags>\n" +
                "\t<status>available</status>\n" +
                "</Pet>\n";
        String jsonObject="{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        RequestSpecification requestSpecification= RestAssured.given()
        //https://petstore.swagger.io/v2/pet
                .baseUri("https://petstore.swagger.io")
         .basePath("/v2/pet")
         .header("accept","application/xml")
         .header("Content-Type","application/xml")
               // .body(jsonObject);
        .body(xmlObject);
        Response response=requestSpecification .post();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200,"Check for status code");
        response.then().body("Pet.name", Matchers.equalTo("doggie"));
    }

    @Test
    public void getData(){
        {
            RestAssured.useRelaxedHTTPSValidation();



            RequestSpecification requestSpecification= RestAssured.given()
                    //http://restapi.adequateshop.com/swagger/index.html#/BlueLion/BlueLion_GetList
                    .baseUri("http://restapi.adequateshop.com")
                    .basePath("/assets/allassets")
                    .queryParams("filterType","All")
                    //.header("Authorization", "Bearer " + token)
                    .header("Accept","application/json")
                    .log().all();

            Response response=requestSpecification.get();
            System.out.println("Status Code: " + response.getStatusCode());
            response.prettyPrint();
            response.then().log().all();


//            Assert.assertEquals(response.statusCode(),200,"Check for status code");
//            response.then().body("Pet.name", Matchers.equalTo("doggie"));
        }
    }
}
