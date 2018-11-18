package leetcode.$51_$100;

/**
 * Created by Yang Liu on 2018/11/18
 */

// Edit Distance
public class $72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // [0...i-2] [0..j-2]已知，i-1 == j-1 => 不需要变化
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    /*
                      1.replace word1[i-1] by word2[j-1], dp[i][j] = dp[i-1][j-1] + 1
                      2.delete word1[i-1] and word1[0...i-2] == word[0...j-1], dp[i][j] = dp[i-1][j] + 1
                      3.insert word2[j-1] to word1[0...i-1] and word1[0...i-1] + word2[j-1] == word2[0..j-1]
                        dp[i][j] = dp[i][j-1] + 1
                     */
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }

    // 节省空间，时间复杂度也更低
    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = i;
        }
        for (int j = 1; j <= n; j++) {
            int pre = dp[0];
            dp[0] = j;
            for (int i = 1; i <= m; i++) {
                int temp = dp[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i] = pre;
                } else {
                    dp[i] = Math.min(pre + 1, Math.min(dp[i] + 1, dp[i - 1] + 1));
                }
                pre = temp;
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        $72 solution = new $72();
        System.out.println(solution.minDistance1(word1, word2));
    }
}
