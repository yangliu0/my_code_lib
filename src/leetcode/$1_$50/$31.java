package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2018/11/26
 */

// Next Permutation
public class $31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;   // 找到第一个打破递减的i
        if (i >= 0) {   // 不是完全递减的序列
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--; // 找到最右边大于i的index
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);  // reverse递减序列
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) swap(nums, start++, end--);
    }
}
