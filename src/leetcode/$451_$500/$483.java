package leetcode.$451_$500;

import java.math.BigInteger;

/**
 * Created by Yang Liu on 2019/10/23
 */

// Smallest Good Base
public class $483 {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        long res = 0;
        for (int k = 60; k >= 2; k--) {
            long s = 2, e = num;
            while (s < e) {
                long m = s + (e - s) / 2;
                BigInteger left = BigInteger.valueOf(m);
                left = left.pow(k).subtract(BigInteger.ONE);
                BigInteger right = BigInteger.valueOf(num).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
                int cmp = left.compareTo(right);
                if (cmp == 0) {
                    res = m;
                    break;
                } else if (cmp < 0) {
                    s = m + 1;
                } else {
                    e = m;
                }
            }
            if (res != 0) {
                break;
            }
        }

        return String.valueOf(res);
    }
}
