package leetcode.$1_$50;

import java.util.Stack;

/**
 * Created by Yang Liu on 2018/11/19
 */

// Valid Parentheses
public class $20 {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        // 可以用数组表示stack，加快速度
        Stack<Character> leftStack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == '(' || c == '[' || c == '{') {
                leftStack.push(c);
            } else if (!leftStack.isEmpty() && ((leftStack.peek() == '(' && c == ')')
                    || (leftStack.peek() == '[' && c == ']') || (leftStack.peek() == '{' && c == '}'))) {
                leftStack.pop();
            } else {
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
