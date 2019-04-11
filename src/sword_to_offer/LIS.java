package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/3
 */

// 最长递增子序列
public class LIS {
    public static int lis(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // dp[i]表示以i结尾的最长递增子序列长度
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < arr.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxLen) {
                        maxLen = dp[i];
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(arr));
    }
}
