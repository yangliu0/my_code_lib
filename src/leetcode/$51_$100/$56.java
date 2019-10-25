package leetcode.$51_$100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang Liu on 2019/9/24
 */

// Merge Intervals
public class $56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));

        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
