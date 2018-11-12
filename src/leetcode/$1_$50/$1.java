package leetcode.$1_$50;

// 1. Two Sum

import java.util.HashMap;
import java.util.Map;

public class $1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        $1 solution = new $1();
        int[] result = solution.twoSum(nums, target);
        for (int item : result) {
            System.out.printf("%d ", item);
        }
    }
}
