package sword_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Yang Liu on 2019/4/10
 */

// 圆圈中最后剩下的数字
public class $62 {
    // 公式法
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; ++i) {
            last = (last + m) % i;
        }

        return last;
    }


    // 链表法，还是借助了公式简化
    public int LastRemaining_Solution1(int n, int m) {
        if (m == 0 || n == 0) {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
}
