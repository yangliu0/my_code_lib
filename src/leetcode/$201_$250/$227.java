package leetcode.$201_$250;


import java.util.Stack;

// Basic Calculator II
public class $227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        s += '+';
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                number = 10 * number + (c - '0');
                continue;
            }
            if (c == ' ') {
                continue;
            }
            if (op == '+') {
                stack.push(number);
            } else if (op == '-') {
                stack.push(-number);
            } else if (op == '*') {
                stack.push(stack.pop() * number);
            } else if (op == '/') {
                stack.push(stack.pop() / number);
            }
            op = c;
            number = 0;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
