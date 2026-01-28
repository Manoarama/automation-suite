package question.example.leetCode;

public class FindMissingAndRepeatedValues_2965 {

    // Method to find repeating and missing numbers
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;          // Size of matrix (n x n)
        int size = n * n;             // Total expected numbers
        int[] count = new int[size + 1]; // Frequency array
        int repeating = -1, missing = -1;
        // STEP 1: Count frequency of each number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }
        // STEP 2: Identify repeating and missing
        for (int num = 1; num <= size; num++) {
            if (count[num] == 2) {
                repeating = num;
            }
            if (count[num] == 0) {
                missing = num;
            }
        }
        return new int[]{repeating, missing};
    }

    // MAIN METHOD
    public static void main(String[] args) {
        // Input matrix
        int[][] grid = {
                {1, 3},
                {2, 2}
        };
        // Create object of Solution class
        FindMissingAndRepeatedValues_2965 sol = new FindMissingAndRepeatedValues_2965();
        // Call the method
        int[] result = sol.findMissingAndRepeatedValues(grid);
        // Print output
        System.out.println("Repeating number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
    }
}
