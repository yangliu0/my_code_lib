package leetcode.$51_$100;

import java.util.Arrays;

/**
 * Created by Yang Liu on 2019/8/3
 */

// Maximal Rectangle
public class $85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, maxA = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n - 1);

        for (int i = 0; i < m; i++) {
            int curR = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curR);
                } else {
                    right[j] = n - 1;
                    curR = j - 1;
                }
            }

            int curL = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curL);
                    height[j]++;
                    maxA = Math.max(maxA, (right[j] - left[j] + 1) * height[j]);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curL = j + 1;
                }
            }
        }
        return maxA;
    }
}
