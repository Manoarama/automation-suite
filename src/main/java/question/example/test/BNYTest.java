package question.example.test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BNYTest {



        public static void main(String[] args) {
            String input = "My name is Manorama";
            Set<Character> vowels = new LinkedHashSet<>();
            Set<Character> consonants = new LinkedHashSet<>();

            String lower = input.toLowerCase();

            for (char ch : lower.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if ("aeiou".indexOf(ch) >= 0) {
                        vowels.add(ch);
                    } else {
                        consonants.add(ch);
                    }
                }
            }

            System.out.println("Unique Vowels: " + vowels);
            System.out.println("Unique Consonants: " + consonants);
        }
    }





