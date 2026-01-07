package question.example.test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BNYTest {
    public static Map<String, Set<Character>> findVowelsAndConsonants(String input) {

        Set<Character> vowels = new LinkedHashSet<>();
        Set<Character> consonants = new LinkedHashSet<>();

        for (char ch : input.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) >= 0) {
                    vowels.add(ch);
                } else {
                    consonants.add(ch);
                }
            }
        }

        Map<String, Set<Character>> result = new HashMap<>();
        result.put("vowels", vowels);
        result.put("consonants", consonants);

        return result;   // ✅ returning result
    }

    public static void main(String[] args) {
        String input = "My name is Manorama";
        Map<String, Set<Character>> result = findVowelsAndConsonants(input);
        System.out.println("Unique Vowels: " + result.get("vowels"));
        System.out.println("Unique Consonants: " + result.get("consonants"));
    }


}





