package Question.Interview;

import java.util.HashMap;
import java.util.Map;

public class TestPhotonJava {
    public static void main(String[] args) {
        //"sele@niu&mau%to*ma#tion!";
        String input = "seleniumisanopensourceautomationtool";
        findDuplicateCharacters(input);
        String input1 = "sele@niu&mau%to*ma#tion!";
        System.out.println(removeSpecialCharacter(input1));

    }
    //Identify duplicate  character and print their occurances
    public static void findDuplicateCharacters(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else
                map.put(c, 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey()+"->"+entry.getValue());
            }
        }
    }
public static String removeSpecialCharacter(String input){
    return input.replaceAll("[^a-zA-Z0-9]","");
}

}