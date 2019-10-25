package leetcode.$51_$100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Yang Liu on 2019/10/21
 */

// Simplify Path
public class $71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                stack.pollLast();
            } else if (!"".equals(s) && !".".equals(s)) {
                stack.offerLast(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.size() == 0) {
            return "/";
        }
        while (stack.size() != 0) {
            sb.append("/").append(stack.pollFirst());
        }
        return sb.toString();
    }
}
