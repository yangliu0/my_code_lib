package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/9/29
 */
public class $32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int open = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')' && open > 0) {
                dp[i] = 2 + dp[i - 1];
                if (i - dp[i] > 0) {
                    dp[i] += dp[i - dp[i]];
                }
                open--;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
