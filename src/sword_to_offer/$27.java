package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/3
 */

// 二叉树的镜像
public class $27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
