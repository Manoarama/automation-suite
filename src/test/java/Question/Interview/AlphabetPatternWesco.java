package Question.Interview;
// Correction required
public class AlphabetPatternWesco {
    // Utility: check vowel
    private static boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    /**
     * Generates the pattern:
     * - Vowels printed once.
     * - Consonants repeated based on the number of vowels encountered so far.
     *   After A -> repeat 1, after E -> repeat 2, after I -> repeat 3, after O -> repeat 4, after U -> repeat 5.
     */
    public static String generatePattern() {
        StringBuilder sb = new StringBuilder();
        int vowelsSeen = 0; // counts vowels encountered so far

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (isVowel(ch)) {
                // Print vowel once and move to next segment
                sb.append(ch);
                vowelsSeen++;
                // Optional: add a single space as a visual separator between vowel segments
                sb.append(' ');
            } else {
                // Consonant: repeat based on current segment (vowels seen so far)
                int repeat = Math.max(vowelsSeen, 1); // after A -> 1, after E -> 2, ..., after U -> 5
                for (int i = 0; i < repeat; i++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString().trim(); // trim to remove trailing space
    }

    // Separate caller (can be main or used in tests)
    public static void main(String[] args) {
        String output = generatePattern();
        System.out.println(output);
    }
}

