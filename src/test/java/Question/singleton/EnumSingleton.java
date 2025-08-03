package Question.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class SampleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = EnumSingleton.INSTANCE.getDriver();
    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        EnumSingleton.INSTANCE.quitDriver();
    }
}
public enum EnumSingleton {
    INSTANCE;

    private ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (tlDriver.get() == null) {
            tlDriver.set(new ChromeDriver());
        }
        return tlDriver.get();
    }

    public void quitDriver() {
        tlDriver.get().quit();
        tlDriver.remove();
    }
}
