package Question.singleton;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class Testclass {

    public static void main(String[] args) {
        int[] a={8,2,5,3};
        int[] b={6,4,8,3};
        //removeDuplicate(a,b);

        String input="Manorama";

       // printcountOfcharacter(input);

    }
/*

    private static void printcountOfcharacter(String input) {
j
        HashMap<Character ,Integer> map =new HashMap<>();

        for(char c:input.toCharArray()){

            map.put(Character.toLowerCase(c),map.getOrDefault(Character.toLowerCase(c),0)+1);
        }

        System.out.println(map);

    }

    private static void removeDuplicate(int[] a, int[] b) {

        Set <Integer> result=new HashSet<>();

        for(int i = 0; i < a.length; i++){
            result.add(a[i]);

        }
        for(int i = 0; i < b.length; i++){
            result.add(b[i]);

        }
        System.out.println(result);
    }
*/

/*WebDriver driver=new ChromeDriver();
    driver.get("");
   driver.findelement(By.xpath("SingInButton xpath")).click();
    driver.findelement(By.xpath("")).sendKey("ID");
    driver.findelement(By.xpath("")).sendKey("password);
    driver.findelement(By.xpath("login")).click();*/

}
