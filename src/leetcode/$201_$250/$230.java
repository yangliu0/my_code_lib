package leetcode.$201_$250;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/7/17
 */

// Kth Smallest Element in a BST
public class $230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int number = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode root) {
        if (root.left != null) {
            helper(root.left);
        }
        count--;
        if (count == 0) {
            number = root.val;
            return;
        }
        if (root.right != null) {
            helper(root.right);
        }
    }

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();

        while (root != null) {
            s.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode node  = s.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            TreeNode right = node.right;
            while (right != null) {
                s.push(right);
                right = right.left;
            }
        }

        return -1;
    }


}
