package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import framework.base.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentHooks {
    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@UI")) {
            DriverFactory.getInstance().initDriver();  // Only for UI scenarios
        }

        ExtentTest test = extent.createTest(scenario.getName());
        testThread.set(test);
        getTest().info("Starting Scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed() && scenario.getSourceTagNames().contains("@UI")) {
            WebDriver driver = DriverFactory.getInstance().getDriver();
            String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            getTest().fail("Scenario Failed").addScreenCaptureFromBase64String(screenshot);
        } else {
            getTest().pass("Scenario Passed");
        }

        if (scenario.getSourceTagNames().contains("@UI")) {
            DriverFactory.getInstance().quitDriver();
        }

        extent.flush();
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }




@AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getInstance().getDriver();
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ExtentReportManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
        }
    }
}

