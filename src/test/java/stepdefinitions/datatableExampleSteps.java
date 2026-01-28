package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class datatableExampleSteps {
    @Given("user enters login details")
    public void user_enters_login_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps();

        String username = data.get(0).get("username");
        String password = data.get(0).get("password");

        System.out.println(username + " " + password);
    }
    private Response response;
    private Map<String, String> requestData;

    // -------------------------------
    // GIVEN STEP
    // -------------------------------
    @Given("user provides request payload")
    public void user_provides_request_payload(DataTable dataTable) {

        // Convert DataTable to Map
        requestData = dataTable.asMaps().get(0);

        // Base URI setup
        RestAssured.baseURI = "https://reqres.in";

        System.out.println("Request Payload: " + requestData);
    }

    // -------------------------------
    // WHEN STEP
    // -------------------------------
    @When("user calls create user API")
    public void user_calls_create_user_api() {

        response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestData)
                        .when()
                        .post("/api/users");

        response.then().log().all();
    }

    // -------------------------------
    // THEN STEP
    // -------------------------------
    @Then("response status code should be {int}")
    public void response_status_code_should_be(Integer statusCode) {

        response.then()
                .statusCode(statusCode);
    }

    // -------------------------------
    // AND STEP
    // -------------------------------
    @And("response should contain {string} as {string}")
    public void response_should_contain(String key, String value) {

        response.then()
                .body(key, equalTo(value));
    }
}

