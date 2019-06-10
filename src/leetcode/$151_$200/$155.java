package leetcode.$151_$200;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/5/15
 */
public class $155 {
    class MinStack {
        Stack<Integer> data;
        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            if (!data.isEmpty()) {
                if (x < min.peek()) {
                    min.push(x);
                } else {
                    min.push(min.peek());
                }
                data.push(x);
            } else {
                data.push(x);
                min.push(x);
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
