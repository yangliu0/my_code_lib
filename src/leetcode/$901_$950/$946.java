package leetcode.$901_$950;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/9/4
 */

// Validate Stack Sequences
public class $946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
