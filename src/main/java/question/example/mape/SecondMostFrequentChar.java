package question.example.mape;

import jakarta.persistence.criteria.CriteriaBuilder;
import jdk.jfr.Frequency;

import java.util.HashMap;
import java.util.Map;

public class SecondMostFrequentChar {
    public static void main(String[] args) {
        String input = "aaaaabbbbvvvq";
    Character result = findSecondMostFrequentChar(input);
        if (result != null) {
            System.out.println("Second most frequent character : " + result);
        } else
            System.out.println("No second most frequent character found");
    }

    public static char findSecondMostFrequentChar(String str) {
        if (str == null || str.length() < 2) {
            throw new IllegalArgumentException("String must have at least two characters");
        }

        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find first and second highest frequency
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        char firstChar = '\0';
        char secondChar = '\0';

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int count = entry.getValue();
            if (count > firstMax) {
                secondMax = firstMax;
                secondChar = firstChar;

                firstMax = count;
                firstChar = entry.getKey();
            } else if (count > secondMax && count != firstMax) {
                secondMax = count;
                secondChar = entry.getKey();
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second most frequent character");
        }

        return secondChar;
    }

}






