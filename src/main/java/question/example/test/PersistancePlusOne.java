package question.example.test;

import java.util.Arrays;

public class PersistancePlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // Increase last non-9 digit
                return digits;
            }
            digits[i] = 0; // Set current digit to 0 if it was 9
        }

        // If all digits were 9, create a new array with an extra digit
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
        PersistancePlusOne plusOneLogic = new PersistancePlusOne(); // Create an instance

        int[][] testCases = {
                {1, 2, 3},
                {1, 2, 9},
                {9, 9, 9}
        };

        for (int[] testCase : testCases) {
            System.out.println("Input: " + Arrays.toString(testCase));
            int[] result = plusOneLogic.plusOne(testCase);
            System.out.println("Output: " + Arrays.toString(result) + "\n");
        }
    }
}
