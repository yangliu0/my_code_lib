package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2018/11/18
 */

// Best Time to Buy and Sell Stock
public class $121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxSoFar, maxCur);
        }
        return maxSoFar;
    }

    // 找到最小值，maxProfit为最大的差值
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        $121 solution = new $121();
        int[] stock = {7, 1, 5, 4, 6, 4};
        System.out.println(solution.maxProfit(stock));
    }
}
