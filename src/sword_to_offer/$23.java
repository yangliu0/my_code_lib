package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/3
 */
// 链表中环的入口
public class $23 {
    public static class ListNode {
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

    // 找到环中一个结点
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

    // 直接将一个结点还原到head，然后跟环内结点一起，一次走一步，相交点即为入环口
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }

        ListNode slow = pHead;
        while (slow != meetingNode) {
            slow = slow.next;
            meetingNode = meetingNode.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        $23 solution = new $23();
        System.out.println(solution.EntryNodeOfLoop1(node1).val);
    }
}

