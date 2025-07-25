package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By searchInput = By.id("search-keyword");
    private By searchBtn = By.cssSelector("button[type='submit']");
    private By applyBtn = By.xpath("//a[contains(text(),'Apply Now')]");

    public void searchJob(String jobTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(jobTitle);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    public void selectJob(String jobTitle) {
        By dynamicJobLink = By.xpath("//a[contains(text(),'" + jobTitle + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(dynamicJobLink)).click();
    }

    public String getJobTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.job-title"))).getText();
    }

    public String getJobLocation() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job-location"))).getText();
    }

    public String getJobId() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job-id"))).getText();
    }

    public String getJobDescription() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job-description p"))).getText();
    }

    public String getRequirementsText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job-requirements"))).getText();
    }

    public void clickApply() {
        wait.until(ExpectedConditions.elementToBeClickable(applyBtn)).click();
    }

    public String getApplyPageJobTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.job-title"))).getText();
    }

    public String getApplyPageJobLocation() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job-location"))).getText();
    }

    public String getApplyPageJobId() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".job-id"))).getText();
    }

    public boolean verifyApplyPageInfo(String expectedTitle, String expectedLocation, String expectedId) {
        return getApplyPageJobTitle().equals(expectedTitle)
                && getApplyPageJobLocation().equals(expectedLocation)
                && getApplyPageJobId().equals(expectedId);
    }
}
