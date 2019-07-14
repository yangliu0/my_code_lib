package leetcode.$451_$500;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/7/13
 */

// Can I Win
public class $464 {
    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }
        map = new HashMap<>();
        used = new boolean[maxChoosableInteger + 1];
        return help(desiredTotal);
    }

    private boolean help(int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        int key = format(used);
        if (!map.containsKey(key)) {
            // 尝试所有未知的number
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    // 检查是否可以win（另一边lose）
                    if (!help(desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    private int format(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) {
                num |= 1;
            }
        }
        return num;
    }
}
