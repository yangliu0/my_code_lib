package sword_to_offer;

import java.util.Stack;

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

    TreeNode res;
    int count;
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }

        count = k;
        helper(pRoot);
        return res;
    }

    private void helper(TreeNode root) {
        if (root.left != null) {
            helper(root.left);
        }
        count--;
        if (count == 0) {
            res = root;
            return;
        }
        if (root.right != null) {
            helper(root.right);
        }
    }

    // 非递归方法
    TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }

            if (!stack.isEmpty()) {
                pRoot = stack.pop();
                k--;
                if (k == 0) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
