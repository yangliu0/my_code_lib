package leetcode.$1201_$1250;

/**
 * Created by Yang Liu on 2019/10/17
 */

// Ugly Number III
public class $1201 {
    public long gcd(long a, long b) {
        if (a > b) {
            return gcd(b, a);
        }

        if (a == 0) {
            return b;
        } else {
            return gcd(a, b % a);
        }
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int o = 0;
        long low = 1;
        long high = Integer.MAX_VALUE;

        while (low < high) {
            long mid = low + (high - low) / 2;
            o = (int) ((mid / a) + (mid / b) + (mid / c) - (mid / lcm(a, b)) - (mid / lcm(a, c)) - (mid / lcm(b, c))
                    + (mid / lcm(a, lcm(b, c))));
            if (o < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }
}
