package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/3
 */

// 反转链表
public class $24 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode reversedHead = null;
        while (current != null) {
            ListNode next = current.next;
            if (next == null) {
                reversedHead = current;
            }
            current.next = pre;
            pre = current;
            current = next;
        }
        return reversedHead;
    }
}
