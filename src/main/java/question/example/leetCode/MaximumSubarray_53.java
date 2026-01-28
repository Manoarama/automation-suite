package question.example.leetCode;

public class MaximumSubarray_53 {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // either start fresh from nums[i] OR extend the previous subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums1)); // 6

        int[] nums2 = {1};
        System.out.println(maxSubArray(nums2)); // 1

        int[] nums3 = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums3)); // 23
    }
}
