package leetcode.$201_$250;

/**
 * Created by Yang Liu on 2019/5/14
 */
public class $237 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
