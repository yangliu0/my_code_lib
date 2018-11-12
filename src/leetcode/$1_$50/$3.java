package leetcode.$1_$50;

import java.util.HashMap;
import java.util.Map;

public class $3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        $3 solution = new $3();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.printf("%d\n", result);
    }
}
