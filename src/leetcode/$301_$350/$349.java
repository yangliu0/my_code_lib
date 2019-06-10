package leetcode.$301_$350;

import java.util.*;

/**
 * Created by Yang Liu on 2019/5/17
 */

// 两个数组的交集
// Intersection of Two Arrays
public class $349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> intersectionNum = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionNum.add(num);
            }
        }
        int[] result = new int[intersectionNum.size()];
        int i = 0;
        for (int num : intersectionNum) {
            result[i++] = num;
        }
        return result;
    }
}
