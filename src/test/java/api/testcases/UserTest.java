package api.testcases;

import api.endpoints.userEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;

public class UserTest {
Faker faker;
User userPayload;

@BeforeClass
 public  void generateTestdata(){
    faker=new Faker();
    userPayload =new User();
     userPayload.setId(faker.idNumber().hashCode());
     userPayload.setUsername(faker.name().username());
     userPayload.setFirstName(faker.name().firstName());
     userPayload.setLastName(faker.name().lastName());
     userPayload.setEmail(faker.internet().safeEmailAddress());
     userPayload.setPassword(faker.internet().password(5,10));
     userPayload.setPhone(faker.phoneNumber().cellPhone());
    RestAssured.useRelaxedHTTPSValidation();
 }

 @Test(priority=0)
    public void testCreateUser(){
     System.out.println("in Create User ");
     Response response=userEndPoints.createUser(userPayload);
     response.then().log().all();

     //validate
     Assert.assertEquals(response.getStatusCode(),200);
 }


    @Test(priority=1)
    public void getCreateUser(){
        System.out.println("in get Create User ");
        Response response=userEndPoints.createUser(userPayload);
        response.then().log().all();

        //validate
        Assert.assertEquals(response.getStatusCode(),200);
    }


    @Test(priority=2)
    public void testGetUser(){
        Response response=userEndPoints.getUser(this.userPayload.getFirstName());
        response.then().log().all();
        //validate
        Assert.assertEquals(response.getStatusCode(),200);
    }


    @Test(priority=3)
    public void testUpdateUser(){
        System.out.println("in testUpdate User ");
        userPayload.setFirstName(faker.name().firstName());
        Response response=userEndPoints.updateUser(this.userPayload.getFirstName(),userPayload);

        response.then().log().all();        //validate
        Assert.assertEquals(response.getStatusCode(),200);

        //Read weather data is updated or not
        Response responseupdated=userEndPoints.getUser(this.userPayload.getFirstName());
        responseupdated.then().log().all();

    }


    @Test(priority=4)
    public void testDeleteUser(){
        System.out.println("in delete User ");
        userPayload.setFirstName(faker.name().firstName());
        Response response=userEndPoints.deleteUser(this.userPayload.getUsername());

        response.then().log().all();
        //validate
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
