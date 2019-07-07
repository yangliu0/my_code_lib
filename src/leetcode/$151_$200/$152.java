package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2019/7/7
 */

// Maximum Product Subarray
// 乘积最大子序列
public class $152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0], min = nums[0], result = nums[0];
        int tmp;
        for (int i = 1; i < nums.length; i++) {
            tmp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
