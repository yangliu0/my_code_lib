package leetcode.$951_$1000;

/**
 * Created by Yang Liu on 2019/9/5
 */

// Univalued Binary Tree
public class $965 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val != value) {
            return false;
        }

        return dfs(root.left, value) && dfs(root.right, value);
    }


}
