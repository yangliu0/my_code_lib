package leetcode.$551_$600;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/9/29
 */

// Subarray Sum Equals K
public class $560 {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> preSum = new HashMap<>();
        int sum = 0, result = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
