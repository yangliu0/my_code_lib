package leetcode.$351_$400;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yang Liu on 2019/5/18
 */

// First Unique Character in a String
public class $387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.isEmpty() ? -1 : map.entrySet().iterator().next().getValue();
    }

    // 考虑到只有26个字母
    public int firstUniqChar1(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
