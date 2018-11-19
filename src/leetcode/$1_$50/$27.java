package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2018/11/19
 */

// Remove Element
public class $27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0, cur = 0, n = nums.length;
        while (cur < n) {
            if (nums[cur] != val) {
                nums[count++] = nums[cur];
            }
            cur++;
        }
        return count;
    }

    public static void main(String[] args) {
        $27 solution = new $27();
        int[] nums = {3, 2, 2, 3};
        System.out.println(solution.removeElement(nums, 3));
    }
}
