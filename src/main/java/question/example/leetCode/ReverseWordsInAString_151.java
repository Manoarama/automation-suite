package question.example.leetCode;

public class ReverseWordsInAString_151 {

    public static String reverseWords(String s) {
        // Step 1: Clean spaces
        char[] chars = removeExtraSpaces(s).toCharArray();

        // Step 2: Reverse the whole string
        reverse(chars, 0, chars.length - 1);

        // Step 3: Reverse each word
        reverseEachWord(chars);

        return new String(chars);
    }

    private static String removeExtraSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (right >= left && s.charAt(right) == ' ') right--;

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' '); // only one space allowed
            }
            left++;
        }
        return sb.toString();
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    private static void reverseEachWord(char[] chars) {
        int n = chars.length;
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && chars[end] != ' ') end++;
            reverse(chars, start, end - 1);
            start = end + 1;
            end = start;
        }
    }
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1)); // "blue is sky the"

        String s2 = "  hello world  ";
        System.out.println(reverseWords(s2)); // "world hello"

        String s3 = "a good   example";
        System.out.println(reverseWords(s3)); // "example good a"
    }
}
