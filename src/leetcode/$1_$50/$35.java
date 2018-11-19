package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2018/11/19
 */

// Search Insert Position
public class $35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        $35 solution = new $35();
        int[] nums = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 2));
    }
}
