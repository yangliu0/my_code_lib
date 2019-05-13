package leetcode.$101_$150;

import java.util.List;

/**
 * Created by Yang Liu on 2019/4/17
 */
// Triangle
// 三角形最小路径和
public class $120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; --i) {
            List<Integer> tmp = triangle.get(i);

            for (int j = 0; j < tmp.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + tmp.get(j);
            }
        }

        return dp[0];
    }
}
