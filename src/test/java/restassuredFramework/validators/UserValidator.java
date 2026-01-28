package restassuredFramework.validators;

import org.testng.Assert;
import restassuredFramework.model.User;

// Response validations
public class UserValidator {

    public static void validateUser(User user, String expectedName) {
        Assert.assertNotNull(user.getId());
        Assert.assertEquals(user.getName(), expectedName);
        Assert.assertTrue(user.getEmail().contains("@"));
    }
}

