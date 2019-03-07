package sword_to_offer;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Yang Liu on 2019/3/5
 */

// 从上到下打印二叉树
public class $32 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0) {
            TreeNode node = queue.poll();

            result.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    // 之字形打印二叉树
    public static void zPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        // 存放奇数层
        Stack<TreeNode> s1 = new Stack<>();
        // 存放偶数层
        Stack<TreeNode> s2 = new Stack<>();
        int layer = 1;

        s1.push(root);
        while (!s1.empty() || !s2.empty()) {
            if ((layer & 0x1) != 0) {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        System.out.printf("%d ", node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                System.out.println();
                layer++;
            } else {
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        System.out.printf("%d ", node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                System.out.println();
                layer++;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        zPrint(node1);
    }
}
