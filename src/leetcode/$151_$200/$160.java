package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2019/4/7
 */

// Intersection of Two Linked Lists
public class $160 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthOfA = getLength(headA);
        int lengthOfB = getLength(headB);
        int dif = lengthOfA - lengthOfB;
        if (lengthOfA < lengthOfB) {
            // 保持A为长链表
            ListNode temp = headA;
            headA = headB;
            headB = temp;
            dif = -dif;
        }

        while (dif > 0) {
            headA = headA.next;
            --dif;
        }

        for (int i = 0; i < lengthOfB; ++i) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLength(ListNode node) {
        ListNode curr = node;
        int length = 0;
        while (curr != null) {
            ++length;
            curr = curr.next;
        }
        return length;
    }
}
