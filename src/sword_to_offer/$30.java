package sword_to_offer;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/3/4
 */

// 包含min函数的栈
public class $30 {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);

        if (min.size() == 0 || node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
