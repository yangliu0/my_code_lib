package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/3
 */

// 合并两个排序的链表
public class $25 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode mergedHead = null;
        if (list1.val < list2.val) {
            mergedHead = list1;
            mergedHead.next = Merge(list1.next, list2);
        } else {
            mergedHead = list2;
            mergedHead.next = Merge(list1, list2.next);
        }

        return mergedHead;
    }
}
