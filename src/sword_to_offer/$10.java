package sword_to_offer;

/**
 * Created by Yang Liu on 2018/12/2
 */

// 斐波拉契数列
public class $10 {
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long preSecondNum = 0;
        long preFirstNum = 1;
        long fibNum = 0;
        for (int i = 2; i <= n; i++) {
            fibNum = preSecondNum + preFirstNum;

            preSecondNum = preFirstNum;
            preFirstNum = fibNum;
        }
        return fibNum;
    }

    // logN解法
    public long fibonacci3(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[][] tmp = recur_fib(n);
        return tmp[0][1];
    }

    private int[][] recur_fib(int n) {
        if (n <= 1) {
            return new int[][]{{1, 1}, {1, 0}};
        }

        if ((n & 0x1) == 0) {
            int[][] tmp = recur_fib(n / 2);
            tmp = calMatrix(tmp, tmp);
            return tmp;
        } else {
            // 奇数
            int[][] tmp = recur_fib(n / 2);
            tmp = calMatrix(tmp, tmp);
            tmp = calMatrix(tmp, new int[][]{{1, 1}, {1, 0}});
            return tmp;
        }
    }

    private int[][] calMatrix(int[][] m1, int[][] m2) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; ++i) {
            for (int k = 0; k < 2; ++k) {
                for (int j = 0; j < 2; ++j) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacci2(50));
        long endTime = System.currentTimeMillis();
        System.out.printf("\n程序运行时间： %d ms", endTime - startTime);
    }
}

