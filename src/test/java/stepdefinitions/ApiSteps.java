package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.ApiUtils;
import utils.PayloadManager;

    public class ApiSteps {

        Response response;
        String payload;

        @Given("I hit the GET endpoint {string}")
        public void i_hit_the_get_endpoint(String endpoint) {
            response = ApiUtils.get(endpoint);
        }

        @Given("I have a valid user payload")
        public void i_have_a_valid_user_payload() {
            payload = PayloadManager.getUserPayload();
        }

        @When("I hit the POST endpoint {string}")
        public void i_hit_the_post_endpoint(String endpoint) {
            response = ApiUtils.post(endpoint, payload);
        }

        @Then("the status code should be {int}")
        public void the_status_code_should_be(Integer statusCode) {
            response.then().statusCode(statusCode);
        }
    }

