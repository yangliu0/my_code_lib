package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2018/11/19
 */

// House Robber
public class $198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n + 1];
        // dp[i]代表有i个数字的最大结果
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            if (nums[i - 1] > nums[i - 2]) {
                dp[i] = dp[i - 2] + nums[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        $198 solution = new $198();
        System.out.println(solution.rob(nums));
    }
}
