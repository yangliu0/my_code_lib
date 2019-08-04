package leetcode.$51_$100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang Liu on 2019/8/3
 */

// Subsets II
public class $90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmpList, int[] nums, int start) {
        res.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // 跳过重复元素
            tmpList.add(nums[i]);
            backtrack(res, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
