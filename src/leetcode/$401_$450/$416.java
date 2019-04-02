package leetcode.$401_$450;

import java.util.Arrays;

/**
 * Created by Yang Liu on 2019/4/2
 */

// Partition Equal Subset Sum
// 01背包问题
public class $416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        // 总和为奇数
        if ((sum & 0x01) == 1) {
            return false;
        }

        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;

        for (int i = 1; i < n + 1; ++i) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum; ++j) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
