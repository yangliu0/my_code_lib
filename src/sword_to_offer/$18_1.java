package sword_to_offer;

/**
 * Created by Yang Liu on 2019/2/27
 */
// 删除链表中重复的结点
public class $18_1 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) {
            // 当前结点为重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        } else {
            // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
