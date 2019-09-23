package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/8/25
 */
public class $50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                // Integer.MIN_VALUE与MAX_VALUE绝对值不等
                x = x * x;
                n = n / 2;
            }

            n = -n;
            x = 1 / x;
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
