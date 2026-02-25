package question.example.leetCode.Arrays;

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;        // reduce large k
        if (k < 0) {
        k = k + n;    // convert negative to equivalent positive rotation
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }}

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
