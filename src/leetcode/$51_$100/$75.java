package leetcode.$51_$100;

/**
 * Created by Yang Liu on 2019/9/3
 */

// Sort Colors
public class $75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                int tmp = nums[left];
                nums[left] = nums[index];
                nums[index] = tmp;
                left++;
                index++;
            } else if (nums[index] == 2) {
                int tmp = nums[right];
                nums[right] = nums[index];
                nums[index] = tmp;
                right--;
            } else {
                index++;
            }
        }
    }
}
