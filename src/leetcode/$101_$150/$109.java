package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2019/4/3
 */

// Convert Sorted List to Binary Search Tree
// 链表转为二叉树
public class $109 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return backtrack(head);
    }

    private TreeNode backtrack(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            pre = pre.next;
        }
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        root.left = backtrack(dummy.next);
        root.right = backtrack(slow.next);
        return root;
    }

    public static void main(String[] args) {
        // [-10,-3,0,5,9]
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        $109 solution = new $109();
        solution.backtrack(node1);
    }
}
