package APISessions.questions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJSONResponseData {
       // @Test
    void testJsonResponse(){
      given().contentType(ContentType.JSON)
              .when().get("http://localhost:3000/books")
              .then()
              .statusCode(200)
              .header("Content-Type","application/json")
              .body("books[4].title",equalTo("Becoming"));
    }

     @Test
    void testJsonResponseBodyData(){
       Response response= given().contentType(ContentType.JSON)
                .when().get("http://localhost:3000/books");

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
        String bookName=response.jsonPath().get("books[3].title");
         Assert.assertNotNull(bookName, "Book title is null!");
        Assert.assertEquals(bookName,"Becoming");
//jsonObject Class
        //convderting response object to json
        JSONObject jsonObject=new JSONObject(response.getBody().toString());

        for(int i=0;i<jsonObject.getJSONArray("book").length();i++){
            String bookTittle = jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();
            System.out.println(bookTittle);
        }



    }

}
