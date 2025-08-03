
package question.example.test;

public class PermutationGenerator {
    public static void main(String[] args) {
        String input = "ab";
        generatePermutations("", input);
    }

    public static void generatePermutations(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(newPrefix, newRemaining);
        }
    }
}
/*
    public static void main(String[] args) {
        String input = "abcd";
        generatePermutations("", input);
    }

    public static void generatePermutations(String prefix, String remaining) {
        int n = remaining.length();

        if (n == 0) {
            // Base case: if nothing is left, print the built permutation
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                // Choose the current character: remaining.charAt(i)
                // Build new prefix: prefix + chosen character
                // Remove the chosen character from remaining and recurse
                generatePermutations(
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1)
                );
            }
        }
    }


    public void getResponse(){
        Resonse response=given().when().then();


    }
}
*/
