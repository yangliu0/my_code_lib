package leetcode.$1_$50;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yang Liu on 2019/4/2
 */

// Merge k Sorted Lists
public class $23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val > o2.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;

            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return head.next;
    }
}
