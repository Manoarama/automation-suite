package question.example.test;

public class ZigzagMatrixWipro {

    public static void main(String[] args) {
        // Define a 3x4 matrix
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println("Zigzag column-wise traversal:");

        for (int col = 0; col < matrix[0].length; col++) {
            if (col % 2 == 0) {
                // Even column index → top to bottom
                for (int row = 0; row < matrix.length; row++) {
                    System.out.print(matrix[row][col] + " ");
                }
            } else {
                // Odd column index → bottom to top
                for (int row = matrix.length - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }  }