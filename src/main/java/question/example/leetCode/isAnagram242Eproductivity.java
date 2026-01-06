package question.example.leetCode;

public class isAnagram242Eproductivity {

    public static boolean isAnagram(String s, String t) {

        // Step 1: Length check
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Step 3: Count characters in s
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Step 4: Reduce counts using t
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        // Step 5: All counts matched
        return true;
    }
    // MAIN METHOD
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        // Calling the method
        boolean result = isAnagram(s, t);
        // Printing result
        System.out.println(result); // true
    }
}



