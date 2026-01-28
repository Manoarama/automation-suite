package Question.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerSingleton {
    public static WebDriver driver;
    // Private constructor to prevent object creation
    private DriverManagerSingleton(){
    }
    // Public method to provide single instance
    public static WebDriver getDriver(WebDriver driver){
        if(driver==null){
            driver= new ChromeDriver();
            driver.manage().window().maximize();
        }
    return driver;
    }


}
