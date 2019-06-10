package leetcode.$101_$150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang Liu on 2019/5/15
 */


// Path Sum II
public class $113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        List<Integer> path = new LinkedList<>();
        pathSum(root, 0, sum, path, result);
        return result;
    }

    private void pathSum(TreeNode root, int current, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        boolean isLeaf = root.left == null && root.right == null;
        current += root.val;
        path.add(root.val);
        if (isLeaf && current == sum) {
            result.add(new LinkedList<>(path));
        }
        pathSum(root.left, current, sum, path, result);
        pathSum(root.right, current, sum, path, result);
        path.remove(path.size() - 1);
    }
}
