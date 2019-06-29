package sword_to_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Yang Liu on 2019/6/22
 */

// 按之字形顺序打印二叉树
public class $70 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        int layer = 1;
        // 存奇数层
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        // 存偶数层
        Stack<TreeNode> s2 = new Stack<>();

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> tmp = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        tmp.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!tmp.isEmpty()) {
                    result.add(tmp);
                    layer++;
                }
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        tmp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!tmp.isEmpty()) {
                    result.add(tmp);
                    layer++;
                }
            }
        }
        return result;
    }
}
