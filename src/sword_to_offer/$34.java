package sword_to_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Yang Liu on 2019/3/7
 */

// 二叉树中和为某一值的路径
public class $34 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }

        int currentSum = 0;
        Stack<Integer> stack = new Stack<>();
        findPath(root, target, stack, pathList, currentSum);

        return pathList;
    }

    private void findPath(TreeNode root, int target, Stack<Integer> path,
                          ArrayList<ArrayList<Integer>> pathList, int currentSum) {
        currentSum += root.val;
        path.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;

        if (currentSum == target && isLeaf) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : path) {
                list.add(i);
            }
            pathList.add(list);
        }

        if (root.left != null) {
            findPath(root.left, target, path, pathList, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, target, path, pathList, currentSum);
        }

        path.pop();
    }
}
