package leetcode.$201_$250;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/5/14
 */

// Contains Duplicate II
public class $219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        $219 solution = new $219();
        int[] nums = {1, 0, 1, 1};
        System.out.println(solution.containsNearbyDuplicate(nums, 1));
    }
}
