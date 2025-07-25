package stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import framework.base.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CareersPage;
import pages.HomePage;
import listeners.ExtentReportManager;

public class JobSteps {

    private WebDriver driver;
    private HomePage homePage;
    private CareersPage careersPage;

    private String expectedJobTitle;
    private String expectedJobLocation;
    private String expectedJobId;
    ExtentTest test = ExtentReportManager.getTest();

    @Given("I open the LabCorp website")
    public void i_open_the_labcorp_website() {
        driver = DriverFactory.getInstance().getDriver(); // Proper driver initialization
        driver.get("https://www.labcorp.com");
        homePage = new HomePage(driver);
        careersPage = new CareersPage(driver);
        ExtentReportManager.getTest().info("Navigated to LabCorp Careers page");
    }

    @When("I navigate to the Careers page")
    public void navigate_to_careers() {
        homePage.clickCareers();
    }

    @When("I search for job {string}")
    public void search_for_job(String jobTitle) {
        careersPage.searchJob(jobTitle);
    }

    @When("I select the job titled {string}")
    public void select_the_job(String jobTitle) {
        careersPage.selectJob(jobTitle);

        // Capture details for cross-verification
        expectedJobTitle = careersPage.getJobTitle();
        expectedJobLocation = careersPage.getJobLocation();
        expectedJobId = careersPage.getJobId();
    }

    @Then("I should see job title as {string}")
    public void assert_job_title(String expected) {
        Assert.assertTrue("Expected job title mismatch!",
                careersPage.getJobTitle().contains(expected));
    }

    @Then("I should see job location")
    public void assert_job_location() {
        Assert.assertFalse("Job location is empty!", careersPage.getJobLocation().isEmpty());
    }

    @Then("I should see job ID")
    public void assert_job_id() {
        Assert.assertFalse("Job ID is empty!", careersPage.getJobId().isEmpty());
    }

    @Then("I should see the description starts with {string}")
    public void assert_description_start(String expectedStart) {
        Assert.assertTrue("Description doesn't start as expected!",
                careersPage.getJobDescription().startsWith(expectedStart));
    }

    @Then("I should see {string} listed as a required tool")
    public void assert_required_tool(String tool) {
        Assert.assertTrue("Required tool not listed!",
                careersPage.getRequirementsText().contains(tool));
    }

    @When("I click Apply Now")
    public void click_apply_now() {
        careersPage.clickApply();
    }

    @Then("job title, location, and ID should match the previous page")
    public void confirm_job_details_match() {
        Assert.assertEquals("Job title doesn't match after Apply!", expectedJobTitle, careersPage.getApplyPageJobTitle());
        Assert.assertEquals("Job location doesn't match after Apply!", expectedJobLocation, careersPage.getApplyPageJobLocation());
        Assert.assertEquals("Job ID doesn't match after Apply!", expectedJobId, careersPage.getApplyPageJobId());
    }

    // ❌ REMOVE unused empty method unless you implement it later
    // @And("I search for {string}")
    // public void iSearchFor(String arg0) {
    // }

}
