package leetcode.$701_$750;

/**
 * Created by Yang Liu on 2019/9/4
 */

// Find Pivot Index
public class $724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        int accumulate = 0;
        for (int i = n - 2; i >= 0; i--) {
            accumulate += nums[i + 1];
            right[i] = accumulate;
        }

        int accumulateLeft = 0;
        for (int i = 0; i < n; i++) {
            if (accumulateLeft == right[i]) {
                return i;
            }
            accumulateLeft += nums[i];
        }

        return -1;
    }
}
