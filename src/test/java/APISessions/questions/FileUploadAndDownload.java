package APISessions.questions;
import org.testng.annotations.*;
//import static io.restassured.RestAssured.*;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class FileUploadAndDownload {
    @Test
    //not running
    void singleFileUpload(){
        File file=new File("C:\\Users\\287820\\Documents\\AutomationWorkspace\\testUpload1.txt");
        given()
                .multiPart("file",file)
                .contentType("multipart/form-data")
       .when()
                .post("http://localhost:8080/uploadFile")
        .then()
        .statusCode(200)
                .body("fileName",equalTo("testUpload1.txt"))
                .log().all();
    }
    @Test
        //not running
    void twoFileUpload(){
        File file1=new File("C:\\Users\\287820\\Documents\\AutomationWorkspace\\testUpload1.txt");
        File file2=new File("C:\\Users\\287820\\Documents\\AutomationWorkspace\\testUpload2.txt");
        given()
                .multiPart("files",file1)
                .multiPart("files",file2)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadMultipleFiles")
                .then()
                .statusCode(200)
                .body("[0].fileName",equalTo("testUpload1.txt"))
                .body("[1].fileName",equalTo("testUpload2.txt"))
                .log().all();
    }
    @Test
    void multipleFileUpload(){
        File file1=new File("C:\\Users\\287820\\Documents\\AutomationWorkspace\\testUpload1.txt");
        File file2=new File("C:\\Users\\287820\\Documents\\AutomationWorkspace\\testUpload2.txt");
        File [] files={file1,file2};//Wont work for all api
        given()
                .multiPart("files",files)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadMultipleFiles")
                .then()
                .statusCode(200)
                .body("[0].fileName",equalTo("testUpload1.txt"))
                .body("[1].fileName",equalTo("testUpload2.txt"))
                .log().all();
    }
    @Test
    void singhFiledownload(){
         given()
                .when()
                .get("http://localhost:8080/downloadFile/testUpload1.txt")
                .then()
                .statusCode(200)
                .log().body();
    }
}
