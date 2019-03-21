package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/17
 */
// 礼物的最大价值
public class $47 {
    public static int getMaxValue(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }

        int m = values.length;
        int n = values[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0;
                int up = 0;

                if (i > 0) {
                    up = dp[i - 1][j];
                }

                if (j > 0) {
                    left = dp[i][ j - 1];
                }

                dp[i][j] = Math.max(left, up) + values[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int getMaxValue1(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }

        int m = values.length;
        int n = values[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0;
                int up = 0;

                if (i > 0) {
                    up = dp[j];
                }
                if (j > 0) {
                    left = dp[j - 1];
                }
                dp[j] = Math.max(up, left) + values[i][j];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] values = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(getMaxValue(values));
        System.out.println(getMaxValue1(values));
    }
}
