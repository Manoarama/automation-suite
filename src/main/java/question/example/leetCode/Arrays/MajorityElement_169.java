package question.example.leetCode.Arrays;

public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        int count=0;
        int answer=0;
        for(int num:nums){
            if(count==0){
                answer=num;
            }

            if(num==answer){
               count++;
            }
            else{
                count--;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] nums1 = {3,2,3};
        System.out.println("Test1: " + majorityElement(nums1)); // 3

        // Example 2
        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println("Test2: " + majorityElement(nums2)); // 2

        // Calling again (as you listed twice)
        int[] nums3 = {3,2,3};
        System.out.println("Test3: " + majorityElement(nums3)); // 3

        int[] nums4 = {2,2,1,1,1,2,2};
        System.out.println("Test4: " + majorityElement(nums4)); // 2
    }

    }
