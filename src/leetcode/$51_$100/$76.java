package leetcode.$51_$100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yang Liu on 2019/8/4
 */

// Minimum Window Substring
public class $76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0, minLeft = 0;
        int minLength = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }

                while (count == t.length()) {
                    if (right - left + 1 < minLength) {
                        minLeft = left;
                        minLength = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        return minLength > s.length() ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
