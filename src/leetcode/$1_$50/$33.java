package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2018/11/26
 */

//  Search in Rotated Sorted Array
public class $33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        int rot = lo;
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            // 通过偏移来找结果
            int mid = lo + ((hi - lo) >> 1);
            int realMid = (mid + rot) % n;
            if (nums[realMid] == target) {
                return realMid;
            } else if (nums[realMid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                // 右侧有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左侧有序
                if (nums[mid] > target && nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
