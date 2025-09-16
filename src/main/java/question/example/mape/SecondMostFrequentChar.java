package question.example.mape;

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

    private static Character findSecondMostFrequentChar(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        for(int value: freqMap.values()){
            if(value>firstMax){
                secondMax=firstMax;
                firstMax=value;
            } else if (value>secondMax && value<firstMax) {
                secondMax=value;
            }
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
        if(entry.getValue()==secondMax){
        return entry.getKey();
        }
}
        return null;
    }
}


