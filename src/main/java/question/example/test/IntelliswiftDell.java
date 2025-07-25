package question.example.test;

public class IntelliswiftDell {

    public static void main(String[] args) {
        String input = "My name is Manorama";
        String output = reverseWords(input);
        System.out.println(output);
    }

    // Pure method: returns the reversed words as a string
    private static String reverseWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}
