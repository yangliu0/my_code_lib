package sword_to_offer;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/3/5
 */

// 栈的压入、弹出序列
public class $31 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        boolean possible = false;

        if (pushA != null && popA != null
                && popA.length > 0
                && pushA.length == popA.length) {
            Stack<Integer> stack = new Stack<>();
            int nextPush = 0;
            int nextPop = 0;

            while (nextPop < popA.length) {
                while (stack.empty() || stack.peek() != popA[nextPop]) {
                    if (nextPush == pushA.length) {
                        break;
                    }
                    stack.push(pushA[nextPush]);
                    nextPush++;
                }

                if (stack.peek() != popA[nextPop]) {
                    break;
                }

                stack.pop();
                nextPop++;
            }

            if (stack.empty() && nextPop == popA.length) {
                possible = true;
            }
        }
        return possible;
    }
}
