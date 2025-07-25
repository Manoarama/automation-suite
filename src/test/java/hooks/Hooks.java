package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import framework.base.DriverFactory;

    public class Hooks {

        WebDriver driver;

        @Before
        public void setUp() {
            // Initialize driver once before each scenario
            driver = DriverFactory.getInstance().initDriver();
        }

        @After
        public void tearDown() {
            // Quit driver after each scenario
            DriverFactory.getInstance().quitDriver();
        }
    }


