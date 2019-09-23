package leetcode.$851_$900;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/9/6
 */

// Length of Longest Fibonacci Subsequence
public class $873 {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
            for (int j = i; j < n; j++) {
                dp[i][j] = 2;
            }
        }

        for (int j = 2; j < n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int prev = A[j] - A[i];
                if (prev >= A[i]) {
                    break;
                }
                if (!map.containsKey(prev)) {
                    continue;
                }
                dp[i][j] = dp[map.get(prev)][i] + 1;
            }
        }

        int res = 0;
        for (int j = 2; j < n; j++) {
            for (int i = 1; i < n - 1; i++) {
                if (dp[i][j] > 2) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
