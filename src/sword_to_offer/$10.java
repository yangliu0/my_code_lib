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

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacci2(50));
        long endTime = System.currentTimeMillis();
        System.out.printf("\n程序运行时间： %d ms", endTime - startTime);
    }
}

