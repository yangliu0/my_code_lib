package leetcode.$651_$700;

import java.util.*;

/**
 * Created by Yang Liu on 2019/7/13
 */

// Maximum Width of Binary Tree
// 二叉树最大宽度
public class $652 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        q.offer(root);
        map.put(root, 1);
        int currW = 0;
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    start = map.get(node);
                }
                if (i == size - 1) {
                    end = map.get(node);
                }
                if (node.left != null) {
                    map.put(node.left, map.get(node) * 2);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, map.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            currW = end - start + 1;
            maxW = Math.max(currW, maxW);
        }
        return maxW;
    }
}
