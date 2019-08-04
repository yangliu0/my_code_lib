package leetcode.$1_$50;

public class $5 {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.length() - i <= (end - start) / 2) break;
            int j = i, k = i;
            while (k < s.length() - 1 && s.charAt(k) == s.charAt(k + 1)) k++;
            i = k + 1;
            while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(j - 1)) {
                k++;
                j--;
            }
            if (k - j + 1 > end - start) {
                start = j;
                end = k + 1;
            }
        }
        return s.substring(start, end);
    }

    // dp解法
    public String longestPalindrome1(String s) {
        int n = s.length();
        int start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return n == 0 ? "" : s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "abacab";
        $5 solution = new $5();
        String result = solution.longestPalindrome(s);
        System.out.printf("%s", result);
    }
}
