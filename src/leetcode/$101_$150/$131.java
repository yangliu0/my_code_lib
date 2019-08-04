package leetcode.$101_$150;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Liu on 2019/7/4
 */

// 分割回文串
// Palindrome Partitioning
public class $131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> tmpList, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tmpList.add(s.substring(start, i + 1));
                backtrack(res, tmpList, s, i + 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
