package sword_to_offer;

/**
 * Created by Yang Liu on 2019/2/28
 */
// 正则表达式匹配
public class $19 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        int strIndex = 0, patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || pattern[patternIndex] == '.' && strIndex != str.length) {
                return matchCore(str, strIndex, pattern, patternIndex + 2) // pattern后移2，a*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2) // 模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex); // *匹配一个，再匹配str下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
