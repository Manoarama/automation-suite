package Question.Interview;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

class Fruit{
   private String name;
    private int id;
    private String family;
    private String order;
    private String genus;
    private Nutritions nutritions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public void setNutritions(Nutritions nutritions) {
        this.nutritions = nutritions;
    }
}
class Nutritions{
    private int calories;
    private int fat;
    private int sugar;
    private int id;
    private int carbohydrates;
    private int protein;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
public class TestPhotonAPI {
    @BeforeTest
   public void setUp(){
        RestAssured.baseURI = "https://fruityvice.com";
    }
    @Test
    public void validateStatusCode(){
     given()
     .when()
        .get("api/fruit/all")
      .then()
          .statusCode(200);
    }
    @Test
    public void validateResponseNotEmpty(){
        given()
        .when()
            .get("api/fruit/all")
        .then()
             .contentType("application/json")
             .body("size()",greaterThan(0));
    }
@Test
public void validateFruitName(){
        given()
        .when()
           .get("api/fruit/all")
        .then()
           .body("[0].name",equalTo("Persimmon"));
}
@Test
public void validateNestedCalories(){
        given()
        .when()
            .get("api/fruit/all")
        .then()
             .body("[0].nutritions.calories",equalTo(81));
}
@Test
public void validateAppleFamily(){
    List<Map<String ,Object>> fruits=
            given()
            .when()
                .get("api/fruit/all")
                .jsonPath().getList("");

    String appleFamily=null;
    for (Map<String, Object> fruit : fruits) {
        if ("Apple".equals(fruit.get("name"))) {
            appleFamily = fruit.get("family").toString();
            break;
        }
    }
    Assert.assertEquals("Rosaceae", appleFamily);
    }

    @Test
    public void validateCaloriesGreaterThanZero(){
     given()
     .when()
        .get("/api/fruit/all")
       .then()
             .body("nutritions.calories",everyItem(greaterThan(0)));
    }

    @Test
    public void validatePojoDeserialization() {
        Response response=
                given()
                        .when()
                        .get("/api/fruit/all");
        List<Fruit> fruits =response.jsonPath().getList("",Fruit.class);
        Assert.assertTrue(fruits.size()>0);
    }
    @Test
    public void validateAppleCaloriesUsingPojo(){
       List<Fruit> fruits =
                given()
                .when()
                   .get("/api/fruit/all")
                        .jsonPath().getList("",Fruit.class);
       Fruit apple=null;
        for(Fruit fruit:fruits){
            if("Apple".equals(fruit.getName())){
              apple=fruit;
              break;
            }
        }
        Assert.assertEquals(52,apple.getNutritions().getCalories());
    }
}

