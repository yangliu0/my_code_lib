package leetcode.$301_$350;

/**
 * Created by Yang Liu on 2019/7/7
 */

// 递增的三元子序列
// Increasing Triplet Subsequence
public class $334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                // n大于smal，小于等于big
                big = n;
            } else {
                // n 大于small和big
                return true;
            }
        }
        return false;
    }
}
