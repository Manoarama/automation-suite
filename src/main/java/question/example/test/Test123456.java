package question.example.test;

import java.util.HashMap;
import java.util.Map;

public class Test123456 {

    //input: AaaAbCcdDDdc
    //Ouput: A4B1C3D4
    public static void main(String[] args) {
        String input="AaaAbCcdDDdc";
        findCharacterCount123456(input);

    }

    private static void findCharacterCount123456(String input) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:input.toCharArray()){
           map.put(Character.toLowerCase(c),map.getOrDefault(Character.toLowerCase(c),0)+1) ;
        }
        System.out.println(map);
    }

}
