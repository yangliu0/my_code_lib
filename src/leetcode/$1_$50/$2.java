package $1_$50;

public class $2 {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result_head = new ListNode(0);
        ListNode current = result_head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            carry = sum / 10;
            if (carry == 0) {
                if ((l1 == null || l2 == null) && ((l1 == null) != (l2 == null))) {
                    current.next = l1 != null ? l1 : l2;
                    break;
                }
            }
        }
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        return result_head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        $2 solution = new $2();
        ListNode result = solution.addTwoNumbers(l1, l4);
        while (result != null) {
            System.out.printf("%d ", result.val);
            result = result.next;
        }
    }
}
