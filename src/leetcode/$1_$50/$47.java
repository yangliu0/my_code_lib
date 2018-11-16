package leetcode.$1_$50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang Liu on 2018/11/16
 */

// Permutations II
public class $47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ret, new ArrayList<>(), nums, new boolean[nums.length]);
        return ret;
    }

    // 跟46题类似，如果前面数跟当前数相同，只有当前面数是used的时候才继续
    private void backtrack(List<List<Integer>> ret, List<Integer> tmpList, int[] nums, boolean[] used) {
        if (tmpList.size() == nums.length) {
            ret.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tmpList.add(nums[i]);
                backtrack(ret, tmpList, nums, used);
                used[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
