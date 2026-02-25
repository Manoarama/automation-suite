package question.example.leetCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Driver;
import java.util.*;

public class TestEmphasis {
    public static void main(String[] args) {
        List<String> names =new ArrayList<>(Arrays.asList( "Manorama", "Abhay", "Monday",
                    "Wednesday", "Friday", "Manorama", "Abhay"));
                removeduplicateword(names);
    }

    private static List<String> removeduplicateword(List<String> list) {
        Set<String> UniqueSet=new LinkedHashSet<>(list);
        Collection collection;
        return new ArrayList<>(UniqueSet);
    }

}







