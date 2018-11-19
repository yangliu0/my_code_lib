package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2018/11/19
 */

// Remove Duplicates from Sorted Array
public class $26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pre = 0, cur = 0, n = nums.length;
        while (cur < n) {
            if (nums[pre] == nums[cur]) {
                cur++;
            } else {
                nums[++pre] = nums[cur++];
            }
        }
        return pre + 1;
    }

    public static void main(String[] args) {
        int[] nums = {11, 12};
        $26 solution = new $26();
        System.out.println(solution.removeDuplicates(nums));
    }
}
