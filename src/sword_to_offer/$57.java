package sword_to_offer;

import java.util.ArrayList;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 和为s的数字
public class $57 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length <= 1) {
            return res;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int curSum = array[left] + array[right];

            if (curSum == sum) {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            } else if (curSum > sum) {
                --right;
            } else {
                ++left;
            }
        }
        return res;
    }
}
