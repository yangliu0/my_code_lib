package sword_to_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang Liu on 2018/12/2
 */

// 用两个队列实现一个栈
public class $9_1<T> {
    Queue<T> queue1 = new LinkedList<>();
    Queue<T> queue2 = new LinkedList<>();

    public void enqueue(T element) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            // 两个队列均为空，随便找一个插入
            queue1.offer(element);
        } else if (queue1.isEmpty() && !queue2.isEmpty()) {
            queue2.offer(element);
        } else {
            queue1.offer(element);
        }
    }

    public T dequeue() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return null;
        }

        T result = null;
        if (queue1.isEmpty() && !queue2.isEmpty()) {
            while (queue2.size() > 0) {
                result = queue2.poll();
                if (queue2.size() != 0) {
                    queue1.offer(result);
                }
            }
        } else if (!queue1.isEmpty() && queue2.isEmpty()) {
            while (queue1.size() > 0) {
                result = queue1.poll();
                if (queue1.size() != 0) {
                    queue2.offer(result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        $9_1<Integer> myStack = new $9_1<>();
        myStack.enqueue(1);
        myStack.enqueue(2);
        myStack.enqueue(3);
        System.out.println(myStack.dequeue());
        myStack.enqueue(4);
        System.out.println(myStack.dequeue());
    }
}
