package question.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearchExample {
    public static void main(String[] args) {
        // Set the path to your WebDriver (update as needed)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Start Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open Amazon
            driver.get("https://www.amazon.com");

            // 2. Search for an item (e.g., "Bluetooth Speaker")
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("Bluetooth Speaker");
            driver.findElement(By.id("nav-search-submit-button")).click();

            // 3. Wait and click the first result
            Thread.sleep(3000); // Wait for results to load (replace with WebDriverWait in real use)
            WebElement firstResult = driver.findElement(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result'] h2 a"));
            firstResult.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Optionally close the browser after some time
            // driver.quit();
        }
    }
}
