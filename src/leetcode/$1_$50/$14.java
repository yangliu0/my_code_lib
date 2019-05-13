package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/4/16
 */

// Longest Common Prefix
public class $14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            ++i;
        }
        return pre;
    }
}
