package question.example.test;
import com.github.dockerjava.transport.DockerHttpClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Lily {
    public static void main(String[] args) {
        String input ="My name is Manorama Singh";
        System.out.println("Original List"+input);
        /*String result=replaceWordInString(input);
        System.out.println("Original List"+result);*/
        replaceWordInString1(input);
        }

    private static String replaceWordInString(String input) {
        String[] words = input.split(" ");
        List<String> wordlist = new ArrayList<>(Arrays.asList(words));
        // Replace Manorama with Lily
        wordlist.set(3, "Lily");
        // Convert list back to string
        return String.join(" ", wordlist);
    }
    private static List<String> replaceWordInString2(String input) {
        String[] words = input.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.set(3, "Lily");
        return list;
    }
    private static void replaceWordInString1(String input) {
        String result = input.replace("Manorama", "Lily");
        System.out.println(result);
    }
}
//


/* //endpoint-200
        Response response=.() ->
                .Given()
                .get(endpoint)
                When()
                Then()
       // retry-3*//*



public static Boolean getWebElement (){
    */
/*List<WebElement> elements;//=driver.findElements(By.xpath("//*[@id="nav-xshop"]/ul/li"));


    for (int i=1;i<=elements.size();i++){

        WebElement we=driver.findElements(By.xpath[@id="nav-xshop"]/ul/li[i]);
        we.click();*//*


    }}

}
*/
