package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2019/4/9
 */

// Find Peak Element
// 寻找峰值
public class $162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int left = 0, right = n - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (left == n - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
