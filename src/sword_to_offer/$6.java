package sword_to_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Yang Liu on 2018/11/18
 */

// 从尾到头打印链表
public class $6 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 使用栈来反向输出结果
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    // 递归
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            printListFromTailToHeadRecursive(list, listNode);
        }
        return list;
    }

    private void printListFromTailToHeadRecursive(ArrayList<Integer> list, ListNode listNode) {
        if (listNode.next != null) {
            printListFromTailToHeadRecursive(list, listNode.next);
        }
        list.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        $6 solution = new $6();
        List<Integer> res = solution.printListFromTailToHead1(node1);
        for (int num : res) {
            System.out.printf("%d ", num);
        }
    }
}
