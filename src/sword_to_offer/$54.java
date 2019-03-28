package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 二叉搜索树的第k大节点
public class $54 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }

        return kthNodeCore(pRoot, k);
    }

    private TreeNode kthNodeCore(TreeNode pRoot, int k) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = kthNodeCore(pRoot.left, k);
        }

        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            --k;
        }
        if (target == null && pRoot.right != null) {
            target = kthNodeCore(pRoot.right, k);
        }
        return target;
    }
}
