package leetcode.$801_$850;

/**
 * Created by Yang Liu on 2019/9/12
 */

// Largest Sum of Averages
public class $813 {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] memo = new double[n + 1][n + 1];
        double curr = 0;
        for (int i = 0; i < n; i++) {
            curr += A[i];
            memo[i + 1][1] = curr / (i + 1);
        }

        return search(n, K, A, memo);
    }

    private double search(int n, int k, int[] A, double[][] memo) {
        if (memo[n][k] > 0) {
            return memo[n][k];
        }
        if (n < k) {
            return 0;
        }

        double curr = 0;
        for (int i = n - 1; i > 0; i--) {
            curr += A[i];
            memo[n][k] = Math.max(memo[n][k], search(i, k - 1, A, memo) + curr / (n - i));
        }
        return memo[n][k];
    }
}
