package ubs2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.regex.*;

public class WebScraper {

    public static List<String> scrapeEmailAddresses(WebDriver driver, String url) {
        driver.get(url);

        String pageSource = driver.getPageSource();

        Set<String> emails = new HashSet<>();

        Pattern pattern = Pattern.compile(
                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"        );
        Matcher matcher = pattern.matcher(pageSource);

        while (matcher.find()) {
            emails.add(matcher.group().trim());
        }

        return new ArrayList<>(emails);
    }

    public static List<String> scrapeMobileNumbers(WebDriver driver, String url) {
        driver.get(url);

        String pageSource = driver.getPageSource();

        Set<String> numbers = new HashSet<>();

        Pattern pattern = Pattern.compile("\\b\\d{10}\\b");
        Matcher matcher = pattern.matcher(pageSource);

        while (matcher.find()) {
            numbers.add(matcher.group().trim());
        }

        return new ArrayList<>(numbers);
    }
    // ---------- MAIN METHOD (FOR LOCAL RUN) ----------
    public static void main(String[] args) {

        // Set path to chromedriver if not in PATH
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String url = "C:\\Users\\DELL\\Automation\\automation-suite\\src\\test\\resources\\files"; // replace with test page

        List<String> emails = scrapeEmailAddresses(driver, url);
        List<String> mobiles = scrapeMobileNumbers(driver, url);

        System.out.println("Emails Found:");
        emails.forEach(System.out::println);

        System.out.println("\nMobile Numbers Found:");
        mobiles.forEach(System.out::println);

        driver.quit();
    }
}

