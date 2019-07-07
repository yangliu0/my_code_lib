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
        List<List<String>> resultList = new ArrayList<>();
        List<String> currList = new ArrayList<>();
        dfs(s, 0, currList, resultList);
        return resultList;
    }

    private void dfs(String s, int pos, List<String> currList, List<List<String>> resultList) {
        if (pos == s.length()) {
            resultList.add(new ArrayList<>(currList));
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (isPal(s, pos, i)) {
                    currList.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, currList, resultList);
                    currList.remove(currList.size() - 1);
                }
            }
        }
    }

    private boolean isPal(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
