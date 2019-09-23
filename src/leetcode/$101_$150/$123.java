package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2019/8/6
 */

// Best Time to Buy and Sell Stock III
public class $123 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];

        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            }
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin); // 第i天卖出
        }

        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > curMax) {
                curMax = prices[i];
            }
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]); // 第i天买入
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        return maxProfit;
    }
}
