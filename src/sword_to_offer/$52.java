package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 两个链表的第一个公共结点
public class $52 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);
        int lengthDif = len1 - len2;
        ListNode headLong = pHead1;
        ListNode headShort = pHead2;

        if (len1 < len2) {
            lengthDif = len2 - len1;
            headLong = pHead2;
            headShort = pHead1;
        }

        // 先在长链表上走几步
        for (int i = 0; i < lengthDif; ++i) {
            headLong = headLong.next;
        }

        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }

        // 得到第一个公共节点
        ListNode firstCommonNode = headLong;

        return firstCommonNode;
    }

    private int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            ++length;
            node = node.next;
        }
        return length;
    }
}
