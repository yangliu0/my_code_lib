package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 平衡二叉树
public class $55_1 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        IsBalanced(root);
        return isBalanced;
    }

    private int IsBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = IsBalanced(root.left);
        int right = IsBalanced(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return left > right ? left + 1 : right + 1;
    }
}
