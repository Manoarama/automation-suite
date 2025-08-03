package question.example.test;

import java.util.HashMap;
import java.util.Map;

public class TestTest {
    public static void main(String[] args) {
        String input="Manorama";
        findCharacterCount(input);
    }

    private static void findCharacterCount(String input) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c: input.toCharArray()){
            if(map.containsKey(c)) {
            map.put(c,map.get(c)+1);
            }
            else
                map.put(c, 1);
            }
        System.out.println(map);
        }


}

