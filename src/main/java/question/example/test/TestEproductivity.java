package question.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Testeproductivity {
    public static void main(String[] args) {

        List<String> input=Arrays.asList("Alice","Rob","Andrew","Adam","Charlee");
        List<String> result= getListinAccendingOrder(input);
        System.out.println(result);
    }

    private static List<String> getListinAccendingOrder(List<String> input) {
        List<String> sortedList  = new ArrayList<>(input);
        Collections.sort(sortedList);
        return sortedList ;
    }
}
