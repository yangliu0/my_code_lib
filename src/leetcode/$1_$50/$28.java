package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2018/11/22
 */

// Implement strStr()
public class $28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                } else if (i + j == haystack.length()) {
                    return -1;
                } else if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    // KMP算法
    public int strStr1(String haystack, String needle) {
        int i = 0, j = 0;
        int len1 = haystack.length(), len2 = needle.length();
        int[] next = new int[len2 + 1];
        getNextVal(needle, next);
        while (i < len1 && j < len2) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }

    private void getNextVal(String needle, int[] next) {
        int len = needle.length();
        next[0] = -1;
        int k = -1, j = 0;
        while (j < len - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                j++;
                k++;

                if (needle.charAt(j) != needle.charAt(k)) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
    }
}
