package question.example.test;

import java.util.*;

public class SentenceManipulation {
    public static void main(String[] args) {
        String input = "Manorama Singh";
        List<Character> result = getAllUniqueCharacters(input);
        System.out.println("Unique characters: " + result);
    }

    public static List<Character> getAllUniqueCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> uniqueChars = new ArrayList<>();
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            if (c != ' ') { // ignore spaces
                map.put(c, map.getOrDefault(c, 0) + 1);
                System.out.println("Character: " + c + ", Count: " + map.get(c));
            }
        }

        // Collect characters that appear only once
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChars.add(entry.getKey());
            }
        }

        return uniqueChars;
    }

}

