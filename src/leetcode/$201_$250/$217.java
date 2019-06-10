package leetcode.$201_$250;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yang Liu on 2019/5/14
 */

// 存在重复元素
// Contains Duplicate
public class $217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
