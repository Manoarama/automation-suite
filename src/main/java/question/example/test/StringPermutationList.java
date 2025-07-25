package question.example.test;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationList {

    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = getPermutations(input);
        System.out.println("All permutations of \"" + input + "\":");
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }

    public static List<String> getPermutations(String input) {
        List<String> result = new ArrayList<>();
        generatePermutations("", input, result);
        return result;
    }

    public static void generatePermutations(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                generatePermutations(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        result
                );
            }
        }
    }
}

