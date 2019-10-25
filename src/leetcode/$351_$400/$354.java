package leetcode.$351_$400;

import java.util.TreeMap;

/**
 * Created by Yang Liu on 2019/10/24
 */

// Data Stream as Disjoint Intervals
public class $354 {
    TreeMap<Integer, int[]> tree;

    /**
     * Initialize your data structure here.
     */
    public $354() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if (tree.containsKey(val)) {
            return;
        }

        Integer l = tree.lowerKey(val);
        Integer r = tree.higherKey(val);

        if (l != null && r != null && tree.get(l)[1] + 1 == val && r == val + 1) {
            tree.get(l)[1] = tree.get(r)[1];
            tree.remove(r);
        } else if (l != null && tree.get(l)[1] + 1 >= val) {
            tree.get(l)[1] = Math.max(tree.get(l)[1], val);
        } else if (r != null && r == val + 1) {
            tree.put(val, new int[]{val, tree.get(r)[1]});
            tree.remove(r);
        } else {
            tree.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[tree.size()][2];
        int i = 0;
        for (int[] a : tree.values()) {
            res[i++] = a;
        }
        return res;
    }
}
