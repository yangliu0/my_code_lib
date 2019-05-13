package leetcode.$251_$300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Liu on 2019/4/25
 */

// Binary Tree Paths
// 二叉树的路径
public class $257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        searchBT(root, "", res);
        return res;
    }

    private void searchBT(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", res);
        }
    }
}
