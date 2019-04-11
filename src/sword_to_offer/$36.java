package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/13
 */

// 二叉搜索树与双向链表
public class $36 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 指向双向链表的尾结点
    TreeNode lastNodeInList = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        convertNode(pRootOfTree, lastNodeInList);

        TreeNode head = lastNodeInList;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void convertNode(TreeNode node, TreeNode lastNode) {
        if (node == null) {
            return;
        }

        TreeNode current = node;

        if (current.left != null) {
            convertNode(current.left, lastNodeInList);
        }
        current.left = lastNodeInList;

        if (lastNodeInList != null) {
            lastNodeInList.right = current;
        }

        lastNodeInList = current;

        if (current.right != null) {
            convertNode(current.right, lastNodeInList);
        }
    }
}
