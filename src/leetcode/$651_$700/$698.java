package leetcode.$651_$700;

/**
 * Created by Yang Liu on 2019/7/14
 */

// Partition to K Equal Sum Subsets
public class $698 {
    int sum;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        for (int num : nums) {
            sum += num;
        }
        if (k <= 0 || (sum % k) != 0) {
            return false;
        }
        sum /= k;
        visited = new boolean[nums.length];
        return help(nums, 0, 0, k);
    }

    private boolean help(int[] nums, int cur_sum, int start, int k) {
        if (k == 0) {
            return true;
        }
        if (cur_sum == sum) {
            return help(nums, 0, 0, k - 1);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && cur_sum + nums[i] <= sum) {
                visited[i] = !visited[i];
                if (help(nums, cur_sum + nums[i], i + 1, k)) {
                    return true;
                }
                visited[i] = !visited[i];
            }
        }
        return false;
    }
}
