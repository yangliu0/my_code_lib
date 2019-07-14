package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/7/14
 */

// Find First and Last Position of Element in Sorted Array
public class $34 {
    public int[] searchRange(int[] nums, int target) {
        int start = findGreatEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, findGreatEqual(nums, target + 1) - 1};
    }

    // 返回第一个大于等于target的index
    private int findGreatEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
