package question.example.leetCode.Arrays;

import java.util.Arrays;

public class MoveZeroes_283 {
    public static void moveZeroes1(int[] nums) {
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
    public static void moveZeroes(int[] nums) {
        int nz = 0;   // current index scanning array
        int z = 0;   // position where next non-zero should go
        int size=nums.length;
        while (nz < size) {
            if (nums[nz] != 0) {
                int temp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = temp;
                nz++;
                z++;
            } else {
                nz++;
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

}