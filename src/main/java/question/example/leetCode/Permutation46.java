package question.example.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutation46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteSwap(nums, 0, result);
        return result;
    }

    private void permuteSwap(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int v : nums)
                perm.add(v);
            result.add(perm);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteSwap(nums, start + 1, result);
            swap(nums, start, i); // backtrack
        }
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void main(String[] args) {
        Permutation46 ip = new Permutation46();
        int[] nums = {1, 2, 3};
        System.out.println(ip.permute(nums));
    }
}

