package sword_to_offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Yang Liu on 2019/3/28
 */

// 滑动窗口的最大值
public class $59 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        int begin;
        // 队头存储当前滑动窗口最大值的index
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; ++i) {
            begin = i - size + 1;
            if (q.isEmpty()) {
                q.offer(i);
            } else if (begin > q.peekFirst()) {
                // 队头元素过期
                q.pollFirst();
            }

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i]) {
                // 队尾元素小于等于当前num
                q.pollLast();
            }
            q.offer(i);
            if (begin >= 0) {
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}
