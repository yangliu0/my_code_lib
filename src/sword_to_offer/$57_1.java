package sword_to_offer;

import java.util.ArrayList;

/**
 * Created by Yang Liu on 2019/3/25
 */
public class $57_1 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3) {
            return list;
        }

        int small = 1;
        int big = 2;
        int mid = (1 + sum) >>> 1;
        int curSum = small + big;

        while (small < mid) {
            if (curSum == sum) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                for (int i = small; i <= big; ++i) {
                    tmpList.add(i);
                }
                list.add(tmpList);
                curSum -= small;
                ++small;
            } else if (curSum < sum) {
                ++big;
                curSum += big;
            } else {
                curSum -= small;
                ++small;
            }
        }
        return list;
    }
}
