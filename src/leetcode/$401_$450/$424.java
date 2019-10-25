package leetcode.$401_$450;

/**
 * Created by Yang Liu on 2019/10/25
 */

// Longest Repeating Character Replacement
public class $424 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < n; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
