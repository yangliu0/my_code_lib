package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2018/11/26
 */

// Next Permutation
public class $31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        if (i != 0) {
            swap(nums, i - 1);
        }

        reverse(nums, i);
    }

    private void swap(int[] nums, int i) {
        for (int j = nums.length - 1; j > i; j--) {
            if (nums[j] > nums[i]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
        }
    }

    private void reverse(int[] nums, int i) {
        int first = i, last = nums.length - 1;
        while (first < last) {
            int temp = nums[first];
            nums[first++] = nums[last];
            nums[last--] = temp;
        }
    }
}
