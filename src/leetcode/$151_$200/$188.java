package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2019/8/6
 */

// Best Time to Buy and Sell Stock IV
public class $188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int days = prices.length;
        if (k >= days) {
            return maxProfit2(prices);
        }

        // 当天卖出
        int[][] local = new int[days][k + 1];
        // 全局最优利润
        int[][] global = new int[days][k + 1];

        for (int i = 1; i < days; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[days - 1][k];
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
