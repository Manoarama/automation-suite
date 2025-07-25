package question.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartTest {

    public static void main(String[] args) {
        // Set up WebDriverManager to handle the driver setup
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();

        // Open Amazon
        driver.get("https://www.amazon.in");

        // Search for 'iPhone'
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Add further test steps like clicking the 4th search result, adding to cart, etc.

        // Close the browser
        driver.quit();
    }
}
