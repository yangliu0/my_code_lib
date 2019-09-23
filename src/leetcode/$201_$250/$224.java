package leetcode.$201_$250;


import java.util.Stack;

public class $224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        stack.push(sign);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                number = 10 * number + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * number;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                number = 0;
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
        }

        result += sign * number;
        return result;
    }
}
