package leetcode.$351_$400;

import java.util.Random;

/**
 * Created by Yang Liu on 2019/7/7
 */

// 打乱数组
// Shuffle an Array
public class $384 {
    private int[] nums;
    private Random random;

    public $384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] a = nums.clone();
        for (int j = 1; j < a.length; j++) {
            // 类似蓄水池采样算法
            // i == j -> 1/(1+j)
            // j != j -> (1 - 1/(1+j)) * (1/j) = 1/(1/j)
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

