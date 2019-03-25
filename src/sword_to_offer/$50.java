package sword_to_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/3/24
 */

// 第一个只出现一次的字符
public class $50 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        char[] chs = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < chs.length; i++) {
            if (map.get(chs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
