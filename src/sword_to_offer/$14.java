package sword_to_offer;

/**
 * Created by Yang Liu on 2018/12/3
 */

// 剪绳子
public class $14 {
    // dp解法
    public int maxProductAfterCutting1(int length) {
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }

        int[] dp = new int[length + 1];
        dp[0] = 0;
        // 条件判断中已经判断了1 2 3的情况，但是当length==4开始，默认已经至少剪了1刀，所以这里不一定需要再剪
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max;

        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j] * dp[i - j];
                if (max < temp) {
                    max = temp;
                }
                dp[i] = max;
            }
        }

        return dp[length];
    }

    // 贪心
    public int maxProductAfterCutting2(int length) {
        if (length < 2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }

        // 尽可能多地剪去长度为3的子段
        int timesOf3 = length / 3;

        // 当绳子最后剩下长度为4时，不能再剪去长度为3的绳子段
        if (length - 3 * timesOf3 == 1) {
            timesOf3 -= 1;
        }

        int timesOf2 = (length - 3 * timesOf3) / 2;
        return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);

    }

    public static void main(String[] args) {
        $14 solution = new $14();
        System.out.println(solution.maxProductAfterCutting1(8));
    }
}
