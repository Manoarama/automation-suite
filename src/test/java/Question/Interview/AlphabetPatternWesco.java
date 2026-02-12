package Question.Interview;

public class AlphabetPatternWesco {
  /*  In the English alphabet: Each vowel has a position value
    a → 1,e → 2,i → 3,o → 4,u → 5
    The consonant that comes after a vowel is repeated as many times as the vowel’s position value.*/
    static void printPattern() {
        int repeatCount = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // Set repeat count when vowel appears
            if (ch == 'a') repeatCount = 1;
            else if (ch == 'e') repeatCount = 2;
            else if (ch == 'i') repeatCount = 3;
            else if (ch == 'o') repeatCount = 4;
            else if (ch == 'u') repeatCount = 5;

            // If consonant after vowel → repeat
            if (!isVowel(ch) && repeatCount > 0) {
                for (int i = 0; i < repeatCount; i++) {
                    System.out.print(ch);}
            } else {
                System.out.print(ch); }
            System.out.print(", ");
        }
    }

    // Helper method to check vowel
    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // Main method ONLY calls logic
    public static void main(String[] args) {
        printPattern();
    }
}
