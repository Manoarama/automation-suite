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
        DriverFactory.getInstance().initDriver(); // ✅ Required
        ExtentReportManager.createTest(scenario.getName());
        ExtentReportManager.getTest().info("Starting scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getInstance().getDriver();
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ExtentReportManager.getTest()
                    .fail("Scenario Failed")
                    .addScreenCaptureFromBase64String(base64Screenshot);
        } else {
            ExtentReportManager.getTest().pass("Scenario Passed");
        }

        DriverFactory.getInstance().quitDriver();
        ExtentReportManager.flushReport(); // ✅ Only after test finishes
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverFactory.getInstance().getDriver();
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            ExtentReportManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
        }
    }}
