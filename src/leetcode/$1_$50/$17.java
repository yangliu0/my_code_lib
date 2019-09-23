package leetcode.$1_$50;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang Liu on 2019/9/3
 */

// Letter Combinations of a Phone Number
public class $17 {
    private static final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        backtrack("", digits, 0, res);
        return res;
    }

    private void backtrack(String prefix, String digits, int offset, List<String> res) {
        if (offset >= digits.length()) {
            res.add(prefix);
            return;
        }

        String letters = MAPPING[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            backtrack(prefix + letters.charAt(i), digits, offset + 1, res);
        }
    }
}
