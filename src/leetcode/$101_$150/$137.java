package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2019/3/4
 */

// Single Number 2
public class $137 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = (b ^ num) & ~a;
            a = (a ^ num) & ~b;
        }
        return a|b;
    }
}
