package question.example.leetCode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{}; // never reached (as per problem)
    }
    public static void main(String[] args) {
        TwoSum_1 object=new TwoSum_1();
        // Test Case 1: Basic case
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test Case 1 Output: "
                + Arrays.toString(object.twoSum(nums1, target1)));

        // Test Case 2: Middle elements
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Test Case 2 Output: "
                + Arrays.toString(object.twoSum(nums2, target2)));

        // Test Case 3: Duplicate numbers
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Test Case 3 Output: "
                + Arrays.toString(object.twoSum(nums3, target3)));

        // Test Case 4: Negative numbers
        int[] nums4 = {-3, 4, 3, 90};
        int target4 = 0;
        System.out.println("Test Case 4 Output: "
                + Arrays.toString(object.twoSum(nums4, target4)));

        // Test Case 5: Zero values
        int[] nums5 = {0, 4, 3, 0};
        int target5 = 0;
        System.out.println("Test Case 5 Output: "
                + Arrays.toString(object.twoSum(nums5, target5)));

        // Test Case 6: Minimum size array
        int[] nums6 = {1, 2};
        int target6 = 3;
        System.out.println("Test Case 6 Output: "
                + Arrays.toString(object.twoSum(nums6, target6)));
    }
}
