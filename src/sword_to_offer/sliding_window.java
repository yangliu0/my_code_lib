package sword_to_offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Yang Liu on 2019/3/14
 */

// 滑动窗口的最大值
public class sliding_window {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }

        int begin;
        // 保存index
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty()) {
                q.add(i);
            } else if (begin > q.peekFirst()) {
                // 开始位置大于最大元素，最大值过期
                q.pollFirst();
            }

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i]) {
                q.pollLast();
            }
            q.add(i);
            if (begin >= 0) {
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}
