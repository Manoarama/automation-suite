package question.example.leetCode;

import java.util.Arrays;

public class BuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStock121 sol = new BuyAndSellStock121();

        // Define test cases
        int[][] testCases = {
                {7, 1, 5, 3, 6, 4},    // Expected: 5
                {7, 6, 4, 3, 1},       // Expected: 0
                {2, 4, 1},             // Expected: 2
                {1, 2},                // Expected: 1
                {3, 2, 6, 5, 0, 3},    // Expected: 4
        };

        // Expected outputs
        int[] expected = {5, 0, 2, 1, 4};

        // Run and print each test case
        for (int i = 0; i < testCases.length; i++) {
            int result = sol.maxProfit(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            System.out.println("Expected: " + expected[i]);
            System.out.println("Output: " + result);
            System.out.println(result == expected[i] ? "✅ Passed\n" : "❌ Failed\n");
        }
    }
}

