package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2019/3/4
 */

// single number
public class $136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
