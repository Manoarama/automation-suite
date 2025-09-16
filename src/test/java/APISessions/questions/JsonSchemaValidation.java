package APISessions.questions;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.ResponseAwareMatcher.*;

public class JsonSchemaValidation {
    @Test
    void jsonSchema(){
      given()
      .when().get("http://localhost:3000/books")
      .then();
              //.assertThat().body(JsonSchemaValidation);
    }
}
