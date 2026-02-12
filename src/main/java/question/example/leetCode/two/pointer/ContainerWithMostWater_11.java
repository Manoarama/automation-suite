package question.example.leetCode.two.pointer;

import java.util.Arrays;

public class ContainerWithMostWater_11 {
    // Method to calculate maximum water
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);
            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // MAIN METHOD WITH TEST CASES
    public static void main(String[] args) {
        ContainerWithMostWater_11 obj = new ContainerWithMostWater_11();
        // ✅ Test Case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input: " + Arrays.toString(height1));
        System.out.println("Max Water: " + obj.maxArea(height1));

        // ✅ Test Case 2
        int[] height2 = {1, 1};
        System.out.println("Input: " + Arrays.toString(height2));
        System.out.println("Max Water: " + obj.maxArea(height2));

        // ✅ Test Case 3 (Increasing heights)
        int[] height3 = {1, 2, 3, 4, 5};
        System.out.println("\nInput: " + Arrays.toString(height3));
        System.out.println("Max Water: " + obj.maxArea(height3));

        // ✅ Test Case 4 (Decreasing heights)
        int[] height4 = {5, 4, 3, 2, 1};
        System.out.println("Input: " + Arrays.toString(height4));
        System.out.println("Max Water: " + obj.maxArea(height4));

        // ✅ Test Case 5 (All same heights)
        int[] height5 = {4, 4, 4, 4};
        System.out.println("Input: " + Arrays.toString(height5));
        System.out.println("Max Water: " + obj.maxArea(height5));
    }
}
