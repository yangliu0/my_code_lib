package leetcode.$1_$50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang Liu on 2019/8/3
 */

// Combination Sum
public class $39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmpList, int[] nums, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            // 重复使用数字，因此不是i+1
            backtrack(res, tmpList, nums, target - nums[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
