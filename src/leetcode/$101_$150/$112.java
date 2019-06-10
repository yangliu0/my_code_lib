package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2019/5/15
 */

// Path Sum
public class $112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return hasPathSum(root, 0, sum);
    }

    private boolean hasPathSum(TreeNode root, int curr, int sum) {
        if (root.left == null && root.right == null) {
            return curr + root.val == sum;
        }

        curr += root.val;

        boolean left = false, right = false;
        if (root.left != null) {
            left = hasPathSum(root.left, curr, sum);
        }
        if (root.right != null) {
            right = hasPathSum(root.right, curr, sum);
        }

        return left || right;
    }
}
