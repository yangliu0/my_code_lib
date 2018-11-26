package leetcode.$51_$100;

/**
 * Created by Yang Liu on 2018/11/22
 */

// Sqrt(x)
public class $69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1, right = x;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }
}
