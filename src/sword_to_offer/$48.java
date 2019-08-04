package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/18
 */

// 最长不含重复字符的字符串
public class $48 {
    public int longestSubstringWithoutDuplication(String str) {
        int curLength = 0;
        int maxLength = 0;

        // 上一个字符出现的index
        int[] positions = new int[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = -1;
        }
        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            int prevIndex = positions[strs[i] - 'a'];
            if (prevIndex < 0 || i - prevIndex > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - prevIndex;
            }
            positions[strs[i] - 'a'] = i;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }
}
