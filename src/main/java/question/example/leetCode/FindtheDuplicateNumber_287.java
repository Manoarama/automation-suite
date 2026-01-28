package question.example.leetCode;

import java.util.Arrays;

public class FindtheDuplicateNumber_287 {

    // Non-static method
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];          // move 1 step
            fast = nums[nums[fast]];    // move 2 steps
        } while (slow != fast);

        // Phase 2: Find entry point of cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;   // duplicate number
    }

    // main method
    public static void main(String[] args) {

        FindtheDuplicateNumber_287 obj = new FindtheDuplicateNumber_287(); // object creation

        // Test Case 1
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Duplicate: " + obj.findDuplicate(nums1));

        // Test Case 2
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Duplicate: " + obj.findDuplicate(nums2));

        // Test Case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Duplicate: " + obj.findDuplicate(nums3));
    }
}
