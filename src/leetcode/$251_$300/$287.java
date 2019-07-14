package leetcode.$251_$300;

/**
 * Created by Yang Liu on 2019/7/14
 */

// Find the Duplicate Number
public class $287 {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            // 类似带环链表，在环内相遇
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            // 其中一个结点返回起点，一步步走，最终在入环点相遇
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }
}
