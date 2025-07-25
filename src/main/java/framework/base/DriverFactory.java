package framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    private static DriverFactory instance = null;
    private static WebDriver driver;

    // Private constructor to prevent direct instantiation
    private DriverFactory() {}

    // Public method to get the single instance of DriverFactory
    public static DriverFactory getInstance() {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    // Method to initialize WebDriver
    public WebDriver initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup(); // 👍 auto-downloads correct version
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    // Method to get the WebDriver
    public WebDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException("Driver not initialized. Call initDriver() first.");
        }
        return driver;
    }

    // Quit driver and reset instance
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
}