package Question.Interview;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;
import java.util.Map;

public class TestPhotonAPI {
//GetPartcular item in this URL - https://fruityvice.com/api/fruit/all
    public static void main(String[] args) {
        RestAssured.useRelaxedHTTPSValidation();

        // Mock or actual endpoint returning the JSON
        Response response = given()
                .when()
                .get("https://fruityvice.com/api/fruit/all")
                .then()
                .statusCode(200)
                .extract().response();

        // Convert to JsonPath for querying
        JsonPath jsonPath = response.jsonPath();

        // Filter list of maps where order is "Rosales"
        List<Map<String, Object>> rosalesFruits = jsonPath.getList("findAll { it.order == 'Rosales' }");

        // Print the matching fruits
        for (Map<String, Object> fruit : rosalesFruits) {
            System.out.println(fruit.get("name") + " | Order: " + fruit.get("order"));
        }
    }
}

/*
 //"sele@niu&mau%to*ma#tion!";
        String input="seleniumisanopensourceautomationtool";
        //Identify duplicate  character and print their occurances
        HashMap<Character,Integer> map=new HashMap<>();
        char [] chars=input.toCharArray();for(char c: chars){
           if(map.containsKey(c)){
               map.put(c,map.get(c)+1);
             }
            else
                 map.put(c,1);
         }

        if(map.values()>1){

            System.out.println(map.get());

        }*/