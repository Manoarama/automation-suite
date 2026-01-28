package restassuredFramework.client;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import restassuredFramework.model.User;
import restassuredFramework.utils.RetryExecutor;

public class UserApiClient {

    private static final String BASE_URL = "http://localhost:8080/users";
    public Response createUser(User user) {
        return RetryExecutor.execute(() ->
                RestAssured.given()
                        .contentType("application/json")
                        .body(user)
                        .post(BASE_URL)
        );
    }

    public Response getUser(long id) {
        return RetryExecutor.execute(() ->
                RestAssured.given()
                        .get(BASE_URL + "/" + id)
        );
    }

    public Response updateUser(long id, User user) {
        return RetryExecutor.execute(() ->
                RestAssured.given()
                        .contentType("application/json")
                        .body(user)
                        .put(BASE_URL + "/" + id)
        );
    }

    public Response deleteUser(long id) {
        return RetryExecutor.execute(() ->
                RestAssured.given()
                        .delete(BASE_URL + "/" + id)
        );
    }
}
