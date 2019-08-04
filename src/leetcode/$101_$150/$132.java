package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2019/8/4
 */

// Palindrome Partitioning II
public class $132 {
    public int minCut(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n];
        boolean[][] isPal = new boolean[n][n];

        for (int right = 0; right < n; right++) {
            dp[right] = right;
            isPal[right][right] = true;
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 1 || isPal[left + 1][right - 1])) {
                    if (left == 0) {
                        dp[right] = 0;
                    } else {
                        isPal[left][right] = true;
                        dp[right] = Math.min(dp[left - 1] + 1, dp[right]);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
