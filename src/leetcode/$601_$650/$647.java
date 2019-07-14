package leetcode.$601_$650;

/**
 * Created by Yang Liu on 2019/7/13
 */

// Palindromic Substrings
public class $647 {
    int count = 1;
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            help(s, i, i); // 奇数
            help(s, i, i + 1); // 偶数
        }
        return count;
    }

    private void help(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }

    public int countSubstrings1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
