package leetcode.$101_$150;

import java.util.*;

/**
 * Created by Yang Liu on 2019/7/20
 */

// Word Ladder
public class $127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // wordList不转换成set会超时
        Set<String> visited = new HashSet<>(), dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int len = 1;
        while (!q.isEmpty()) {
            for (int i = q.size() - 1; i >= 0; i--) {
                String w = q.poll();
                if (w.equals(endWord)) {
                    return len;
                }

                for (int j = 0; j < w.length(); j++) {
                    char[] chars = w.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (w.charAt(j) == ch) {
                            continue;
                        }
                        chars[j] = ch;
                        String newStr = String.valueOf(chars);
                        if (dict.contains(newStr) && visited.add(newStr)) {
                            q.offer(newStr);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }
}
