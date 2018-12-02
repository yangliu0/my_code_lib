package sword_to_offer;

import java.util.Stack;

/**
 * Created by Yang Liu on 2018/12/2
 */

// 用两个栈实现队列
public class $9<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T element) {
        stack1.push(element);
    }

    public T deleteHead() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.size() == 0) {
            System.out.println("queue is empty");
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        $9<Integer> myQueue = new $9<>();
        myQueue.appendTail(1);
        myQueue.appendTail(2);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        myQueue.appendTail(3);
        System.out.println(myQueue.deleteHead());
    }
}
