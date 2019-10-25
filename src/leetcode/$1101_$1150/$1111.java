package leetcode.$1101_$1150;

/**
 * Created by Yang Liu on 2019/10/17
 */

// Maximum Nesting Depth of Two Valid Parentheses Strings
public class $1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int level = 0, index = 0;
        while (index < seq.length()) {
            if (seq.charAt(index) == '(') {
                res[index] = level++ % 2;
            } else {
                res[index] = --level % 2;
            }
            index++;
        }
        return res;
    }
}
