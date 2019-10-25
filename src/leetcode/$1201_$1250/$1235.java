package leetcode.$1201_$1250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yang Liu on 2019/10/22
 */

// Maximum Profit in Job Scheduling
public class $1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] items = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            items[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(items, (o1, o2) -> (o1[1] - o2[1]));
        List<Integer> dpEndtime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndtime.add(0);
        dpProfit.add(0);

        for (int[] item : items) {
            int s = item[0], e = item[1], p = item[2];
            int prevIndex = Collections.binarySearch(dpEndtime, s + 1);
            if (prevIndex < 0) {
                prevIndex = -prevIndex - 1;
            }
            prevIndex--;
            int currentProfit = dpProfit.get(prevIndex) + p;
            int maxProfit = dpProfit.get(dpProfit.size() - 1);
            if (currentProfit > maxProfit) {
                dpProfit.add(currentProfit);
                dpEndtime.add(e);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }
}
