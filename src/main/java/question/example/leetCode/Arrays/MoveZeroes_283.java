package question.example.leetCode.Arrays;

import java.util.Arrays;

public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println("Example 1 Output: " + Arrays.toString(nums1));

        // Example 2
        int[] nums2 = {0};
        moveZeroes(nums2);
        System.out.println("Example 2 Output: " + Arrays.toString(nums2));
    }
    public void moveZeroes1(int[] nums) {
        int j = 0;  // pointer for non-zero position

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}

