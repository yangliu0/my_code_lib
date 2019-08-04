package leetcode.$51_$100;

/**
 * Created by Yang Liu on 2019/7/16
 */

// Rotate List
public class $61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int n = 0;
        while (fast.next != null) {
            fast = fast.next;
            n++;
        }

        for (int i = n - k % n; i > 0; i--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
