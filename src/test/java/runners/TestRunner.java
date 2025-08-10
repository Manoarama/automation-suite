package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "stepdefinitions", "hooks", "listeners" },
        plugin = {"pretty", "html:target/report.html", "json:target/report.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // Optional: override dataProvider for parallel execution
}