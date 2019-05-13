package leetcode.$101_$150;

import java.util.Stack;

/**
 * Created by Yang Liu on 2019/4/25
 */

// Maximum Depth of Binary Tree
// 二叉树的最大深度
public class $104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return (left > right) ? left + 1 : right + 1;
    }

    // 非递归写法
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(1);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            int tmp = stack2.pop();
            max = Math.max(max, tmp);
            if (node.left != null) {
                stack1.push(node.left);
                stack2.push(tmp + 1);
            }
            if (node.right != null) {
                stack1.push(node.right);
                stack2.push(tmp + 1);
            }
        }
        return max;
    }
}
