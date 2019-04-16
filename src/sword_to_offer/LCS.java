package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/2
 */

// 最长公共子序列
// 不要求连续，去掉0或多个字符，不改变相对顺序
public class LCS {

    // 求出最长公共子序列的dp数组
    public int[][] lengthOfLCS(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }

        char[] x = str1.toCharArray();
        char[] y = str2.toCharArray();

        int[][] dp = new int[x.length + 1][y.length + 1];

        for (int i = 1; i <= x.length; ++i) {
            for (int j = 1; j <= y.length; ++j) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    private static StringBuilder stringBuilder = new StringBuilder();
    // 打印最长公共子序列
    public String printLCS(int[][] array, String str1, String str2, int i, int j) {
        if (i == 0 || j == 0) {
            return null;
        }

        char[] x = str1.toCharArray();
        char[] y = str2.toCharArray();

        if (x[i - 1] == y[j - 1]) {
            stringBuilder.append(x[i - 1]);
            printLCS(array, str1, str2, i - 1, j - 1);
        } else if (array[i - 1][j] >= array[i][j - 1]) {
            printLCS(array, str1, str2, i - 1, j);
        } else {
            printLCS(array, str1, str2, i, j - 1);
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        LCS solution = new LCS();
        int[][] dp = solution.lengthOfLCS(str1, str2);
        System.out.printf("LCS长度：%d\n", dp[str1.length()][str2.length()]);
        solution.printLCS(dp, str1, str2, str1.length(), str2.length());
        System.out.println(stringBuilder.reverse().toString());
    }
}
