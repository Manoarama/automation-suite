package question.example.leetCode;

import java.util.Arrays;

public class FindMissingAndRepeatedValues_2965  {

    // Method to find repeating and missing numbers
    public int[] findMissingAndRepeating(int[][] grid) {

        int n = grid.length;
        long N = (long) n * n;

        long expectedSum = N * (N + 1) / 2;
        long expectedSquareSum = N * (N + 1) * (2 * N + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];
                actualSquareSum += (long) grid[i][j] * grid[i][j];
            }
        }

        long diff1 = actualSum - expectedSum;               // a - b
        long diff2 = actualSquareSum - expectedSquareSum;   // a² - b²

        long sumAB = diff2 / diff1;                         // a + b

        long a = (diff1 + sumAB) / 2;                       // repeating
        long b = a - diff1;                                 // missing

        return new int[]{(int) a, (int) b};
    }

    // MAIN METHOD WITH TEST CASES
    public static void main(String[] args) {

        FindMissingAndRepeatedValues_2965 obj = new FindMissingAndRepeatedValues_2965();

        // ✅ Test Case 1
        int[][] grid1 = {
                {1, 3},
                {2, 2}
        };
        System.out.println("Grid 1 Result: " +
                Arrays.toString(obj.findMissingAndRepeating(grid1)));

        // ✅ Test Case 2
        int[][] grid2 = {
                {9, 1, 7},
                {8, 9, 2},
                {3, 4, 6}
        };
        System.out.println("Grid 2 Result: " +
                Arrays.toString(obj.findMissingAndRepeating(grid2)));

        // ✅ Test Case 3 (Smallest n)
        int[][] grid3 = {
                {1, 1},
                {2, 3}
        };
        System.out.println("Grid 3 Result: " +
                Arrays.toString(obj.findMissingAndRepeating(grid3)));
    }
}
