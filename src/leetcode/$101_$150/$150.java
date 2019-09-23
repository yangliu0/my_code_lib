package leetcode.$101_$150;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/9/3
 */

// Evaluate Reverse Polish Notation
public class $150 {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.add(stack.pop() + stack.pop());
            } else if ("/".equals(s)) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            } else if ("*".equals(s)) {
                stack.add(stack.pop() * stack.pop());
            } else if ("-".equals(s)) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
