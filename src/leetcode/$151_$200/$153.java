package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2019/5/15
 */

// Find Minimum in Rotated Sorted Array
public class $153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = left;

        while (nums[left] > nums[right]) {
            mid = left + (right - left) / 2;
            if (right - left == 1) {
                mid = right;
                break;
            }

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else if (nums[left] <= nums[mid]) {
                left = mid;
            }
        }
        return nums[mid];
    }
}
