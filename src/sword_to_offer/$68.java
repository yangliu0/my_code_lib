package sword_to_offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Yang Liu on 2019/4/13
 */

// 树中两个节点的最低公共祖先
// 可能是n叉树，没有指向父节点的指针
public class $68 {
    public static class TreeNode {
        int val;
        ArrayList<TreeNode> children;
    }

    public TreeNode getLastCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        LinkedList<TreeNode> path1 = new LinkedList<>();
        getNodePath(root, node1, path1);

        LinkedList<TreeNode> path2 = new LinkedList<>();
        getNodePath(root, node2, path2);

        return getLastCommonNode(path1, path2);
    }

    // 找到root到target node的路径，存储在链表里
    public boolean getNodePath(TreeNode root, TreeNode node, LinkedList<TreeNode> path) {
        if (root == node) {
            return true;
        }

        path.add(root);

        boolean found = false;
        int i = 0;
        int n = root.children.size();
        while (!found && i < n) {
            found = getNodePath(root.children.get(i), node, path);
            ++i;
        }

        if (!found) {
            path.pop();
        }

        return found;
    }

    // 得到两条从root到target node的链表，求链表第一个公共节点
    public TreeNode getLastCommonNode(LinkedList<TreeNode> path1, LinkedList<TreeNode> path2) {
        Iterator<TreeNode> iter1 = path1.iterator();
        Iterator<TreeNode> iter2 = path2.iterator();

        TreeNode pLast = null;
        while (iter1.hasNext() && iter2.hasNext()) {
            TreeNode node1 = iter1.next();
            TreeNode node2 = iter2.next();
            if (node1 == node2) {
                pLast = node1;
            }
        }

        return pLast;
    }
}
