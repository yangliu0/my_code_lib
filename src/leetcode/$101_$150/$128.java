package leetcode.$101_$150;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/3/5
 */

// Longest Consecutive Sequence
public class $128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;

                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                continue;
            }
        }
        return res;
    }
}
