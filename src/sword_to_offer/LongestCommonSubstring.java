package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/3
 */

// 最长公共子串
public class LongestCommonSubstring {
    public static int lengthOfLCString(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return 0;
        }

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        // 保存最大长度
        int maxLen = 0;
        // 最长字符串在str1中的开始index
        int maxIndex = 0;
        for (int i = 1; i <= str1.length(); ++i) {
            for (int j = 1; j <= str2.length(); ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        maxIndex = i - maxLen;
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // 结果为cba
        String str1 = "acbac";
        String str2 = "acaccbabb";
        System.out.println(lengthOfLCString(str1, str2));
    }
}
