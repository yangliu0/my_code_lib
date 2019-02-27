package sword_to_offer;

/**
 * Created by Yang Liu on 2018/12/3
 */

// 二进制中1的个数
public class $15 {
    public int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }
}
