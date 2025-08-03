package question.example.test;

import java.util.*;

public class StringManualOps {

    public static void main(String[] args) {
        String input = "Manorama";

        System.out.println("Original: " + input);
       System.out.println("Remove Duplicates: " + removeDuplicates(input));
       System.out.println("Vowels Only: " + getVowels(input));
       System.out.println("Unique Characters: " + getUniqueCharacters(input));
        System.out.println("Reversed: " + reverseString(input));

    }



    // 1. Remove duplicate characters
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!seen.contains(Character.toLowerCase(c))) {
                seen.add(Character.toLowerCase(c));
                result.append(c);
            }
        }
        return result.toString();
    }

    // 2. Get only vowels
    public static String getVowels(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 3. Get unique (non-repeating) characters
    public static String getUniqueCharacters(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            char ch = Character.toLowerCase(c);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (countMap.get(Character.toLowerCase(c)) == 1) {
                result.append(c);
            }
        }

        return result.toString();
    }
    // 4. Reverse String
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }







}


