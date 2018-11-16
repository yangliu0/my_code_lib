package leetcode.$1_$50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang Liu on 2018/11/16
 */

// Permutations
public class $46 {
    // 将新数字插入到数字之间，形成全排列 5ms
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
            return ret;
        }
        List<Integer> tmpList = new LinkedList<>();
        tmpList.add(nums[0]);
        ret.add(tmpList);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newRet = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> tmp : ret) {
                    List<Integer> newTmpList = new LinkedList<>(tmp);
                    newTmpList.add(j, nums[i]);
                    newRet.add(newTmpList);
                }
            }
            ret = newRet;
        }
        return ret;
    }

    // 回溯 3ms
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        backtrack(ret, new ArrayList<>(), nums);
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length) {
            ret.add(new ArrayList<>(tmpList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmpList.contains(nums[i])) continue;
                tmpList.add(nums[i]);
                backtrack(ret, tmpList, nums);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    // 回溯，交换数字 2ms
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        backtrack1(ret, nums, 0);
        return ret;
    }

    private void backtrack1(List<List<Integer>> ret, int[] nums, int start) {
        if (start >= nums.length) {
            List<Integer> tmpList = convertArrayToList(nums);
            ret.add(tmpList);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack1(ret, nums, start + 1);
            swap(nums, start, i);
        }
    }

    private List<Integer> convertArrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
