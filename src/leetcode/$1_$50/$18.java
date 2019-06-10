package leetcode.$1_$50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang Liu on 2019/5/18
 */

// 4Sum
public class $18 {
    int len = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index >= len) {
            return result;
        }

        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                // 找一对
                if (target - nums[i] == nums[j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    result.add(tmp);
                    // 跳过重复数字
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (target - nums[i] > nums[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                List<List<Integer>> tmp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (tmp.size() > 0) {
                    for (List<Integer> t : tmp) {
                        t.add(0, nums[i]);
                    }
                    result.addAll(tmp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    // 跳过重复
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        $18 solution = new $18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        solution.fourSum(nums, target);
    }
}
