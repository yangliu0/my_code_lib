package leetcode.$501_$550;

/**
 * Created by Yang Liu on 2019/9/6
 */

// Minimum Absolute Difference in BST
public class $530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}
