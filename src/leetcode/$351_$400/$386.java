package leetcode.$351_$400;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Liu on 2019/7/14
 */

// 字典序排数
// Lexicographical Numbers
public class $386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int cur, int n, List<Integer> res) {
        if (cur > n) {
            return;
        }
        res.add(cur);
        for (int i = 0; i < 10; i++) {
            if (10 * cur + i > n) {
                return;
            }
            dfs(cur * 10 + i, n, res);
        }
    }
}
