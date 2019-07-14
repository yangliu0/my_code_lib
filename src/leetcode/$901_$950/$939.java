package leetcode.$901_$950;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yang Liu on 2019/7/14
 */

// Minimum Area Rectangle
public class $939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((points[i][0] == points[j][0]) || (points[i][1] == points[j][1])) {
                    continue;   // 同在x或y
                }
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    min = Math.min(min, Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
