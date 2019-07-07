package leetcode.$101_$150;

import java.util.List;

/**
 * Created by Yang Liu on 2019/7/4
 */

// Word Break
// 单词拆分
public class $139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
