package APISessions.questions;
import api.payload.postRequestPojo;
import org.json.JSONObject;
import org.json.JSONTokener;
//import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class DifferentWayToCreatePostRequestBody {
    //@Test(priority=1)
    void TestPostUsingHashMap1(){
        HashMap data=new HashMap<>();
        data.put("name","Scott");
        data.put("location","France");
        data.put("phone",987654);
        String [] courseArray={"C","C++"};
        data.put("courses",courseArray);

        given()
                .contentType("application/json")
                .body(data)
         .when()
                .post("http://localhost:3000/students")
         .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("France"))
                .body("phone",equalTo(987654))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type",  equalTo("application/json"));
    }

   @Test(priority=2)
    void testDelete(){
        given()
         .when()
                .delete("http://localhost:3000/students/f36d")
         .then().statusCode(200);
    }


   // @Test(priority=1)
    void TestPostUsingOrgJson2(){
        JSONObject data=new JSONObject();
        data.put("name","Scott");
        data.put("location","France");
        data.put("phone",987654);
        String [] courseArray={"C","C++"};
        data.put("courses",courseArray);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("France"))
                .body("phone",equalTo(987654))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type",  equalTo("application/json"));
    }


    @Test(priority=1)
    void TestPostUsingPojo3(){
        postRequestPojo dataPojo=new postRequestPojo();
        dataPojo.setName("Scott");
        dataPojo.setLocation("France");
        dataPojo.setPhone(987654);
        String [] courseArray={"C","C++"};
        dataPojo.setCourses(courseArray);

        given()
                .contentType("application/json")
                .body(dataPojo)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("France"))
                .body("phone",equalTo(987654))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type",  equalTo("application/json"));
    }

    @Test(priority=1)
    void TestPostUsingExternalJsonFile4() throws FileNotFoundException {

       File file=new File("C:\\Users\\287820\\IdeaProjects\\InterviewQuestions\\src\\test\\resources\\payloads");
        FileReader fileReader =new FileReader(file);
        JSONTokener jsonTokener=new JSONTokener(fileReader);
        JSONObject jsonObject=new JSONObject(jsonTokener);
        given()
                .contentType("application/json")
                .body(jsonObject)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Scott"))
                .body("location",equalTo("France"))
                .body("phone",equalTo(987654))
                .body("courses[0]",equalTo("C"))
                .body("courses[1]",equalTo("C++"))
                .header("Content-Type",  equalTo("application/json"));
    }
}
