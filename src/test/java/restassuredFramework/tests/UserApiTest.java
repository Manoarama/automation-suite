package restassuredFramework.tests;

import io.restassured.response.Response;
import org.junit.Test;
import restassuredFramework.client.UserApiClient;
import restassuredFramework.model.User;
import restassuredFramework.validators.UserValidator;

public class UserApiTest {

    UserApiClient client = new UserApiClient();

    @Test
    public void createUserTest() {
        User user = new User("Bob", "bob@test.com");

        Response response = client.createUser(user);
        User createdUser = response.as(User.class);

        UserValidator.validateUser(createdUser, "Bob");
    }
}


