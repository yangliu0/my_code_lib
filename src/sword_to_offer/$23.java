package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/3
 */
// 链表中环的入口
public class $23 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }

        // 环中节点数
        int nodeInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            nodeInLoop++;
        }

        pNode1 = pHead;
        for (int i = 0; i < nodeInLoop; i++) {
            pNode1 = pNode1.next;
        }

        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode slow = pHead.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}

