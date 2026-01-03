package Question.Interview;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class getRequestValidationJson {
    @Test
    public void validateAvailablePets(){
      given()
              .baseUri("https://petstore.swagger.io")
              .basePath("/v2/pet/findByStatus")
              .queryParam("status","available")
      .when()
              .get()
       .then()
              .statusCode(200)
              .header("content-type","application/json")
              // Response should not be empty
              .body("size()",greaterThan(0))
              // Validate all pets are available
              .body("status",everyItem(equalTo("available")))
              .body("$", not(empty()))
              .body("size()", greaterThan(0))
              .body("$",everyItem(hasKey("id")))
              .body("email",notNullValue())
              .time(lessThan(5000L));
              /*.body("id",everyItem(notNullValue()))
              .body("name",everyItem(notNullValue()));*/
        }
}
