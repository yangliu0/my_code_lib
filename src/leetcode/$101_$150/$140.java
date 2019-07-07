package leetcode.$101_$150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yang Liu on 2019/7/6
 */

// Word Break II
// 单词拆分 II
public class $140 {
    // 缓存，用于剪枝
    HashMap<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (wordDict.contains(s)) {
            result.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String tmpStr = s.substring(i);
            if (wordDict.contains(tmpStr)) {
                List<String> tmp = wordBreak(s.substring(0, i), wordDict);
                if (tmp.size() != 0) {
                    for (int j = 0; j < tmp.size(); j++) {
                        result.add(tmp.get(j) + " " + tmpStr);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
