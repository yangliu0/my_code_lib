package leetcode.$201_$250;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/5/14
 */

// Contains Duplicate III
public class $220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            long reMappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = reMappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && reMappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - reMappedNum <= t)) {
                return true;
            }
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, reMappedNum);
        }
        return false;
    }
}
