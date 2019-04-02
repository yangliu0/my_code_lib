package leetcode.$251_$300;

/**
 * Created by Yang Liu on 2019/3/24
 */

// Move Zeroes
public class $283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++j;
            }
        }
    }
}
