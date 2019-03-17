package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/14
 */

// 连续子数组的最大和
public class $42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int currentSum = 0;
        int greatSum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (currentSum <= 0) {
                currentSum = array[i];
            } else {
                currentSum += array[i];
            }

            if (currentSum > greatSum) {
                greatSum = currentSum;
            }
        }
        return greatSum;
    }

    // dp
    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] dp = new int[array.length];
        dp[0] = array[0];
        int greatSum = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i] > greatSum) {
                greatSum = dp[i];
            }
        }
        return greatSum;
    }
}
