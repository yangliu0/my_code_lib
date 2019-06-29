package sword_to_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang Liu on 2019/6/29
 */

// 把二叉树打印成多行

public class $71 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        int level = 0;
        // 保存奇数层结点
        Queue<TreeNode> q1 = new LinkedList<>();
        // 保存偶数层结点
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(pRoot);


        while (!q1.isEmpty() || !q2.isEmpty()) {
            ArrayList<Integer> tmpList = new ArrayList<>();
            if (level == 0) {
                // 奇数层
                while (!q1.isEmpty()) {
                    TreeNode node = q1.poll();
                    tmpList.add(node.val);
                    if (node.left != null) {
                        q2.offer(node.left);
                    }
                    if (node.right != null) {
                        q2.offer(node.right);
                    }
                }
            } else {
                // 偶数层
                while (!q2.isEmpty()) {
                    TreeNode node = q2.poll();
                    tmpList.add(node.val);
                    if (node.left != null) {
                        q1.offer(node.left);
                    }
                    if (node.right != null) {
                        q1.offer(node.right);
                    }
                }
            }
            result.add(tmpList);
            level = 1 - level;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        $71 solution = new $71();
        solution.Print(node1);
    }
}
