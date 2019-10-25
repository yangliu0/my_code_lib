package leetcode.$301_$350;

/**
 * Created by Yang Liu on 2019/9/6
 */

// Burst Balloons
public class $312 {
    public int maxCoins(int[] nums) {
        int[] arrs = new int[nums.length + 2];
        int n = 1;
        for (int num : nums) {
            if (num > 0) {
                arrs[n++] = num;
            }
        }
        arrs[0] = arrs[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right]
                            , arrs[left] * arrs[i] * arrs[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
