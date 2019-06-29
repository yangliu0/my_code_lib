package sword_to_offer;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/6/29
 */

// 二叉搜索树的第k个结点
public class $72 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 递归方法
    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if (index == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }

    // 非递归方法
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        int index = 0;
        Stack<TreeNode> s = new Stack<>();
        while (pRoot != null || !s.isEmpty()) {
            while (pRoot != null) {
                s.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!s.isEmpty()) {
                pRoot = s.pop();
                index++;
                if (index == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
