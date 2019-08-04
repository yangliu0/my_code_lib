package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/8/4
 */

// Swap Nodes in Pairs
public class $24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
