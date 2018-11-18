package sword_to_offer;

/**
 * Created by Yang Liu on 2018/11/18
 */

// 二叉树的下一个结点
public class $8 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode next = null;
        if (pNode.right != null) {
            // 右结点存在，next为右结点的最左结点
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            next = pRight;
        } else if (pNode.next != null) {
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && pParent.right == pCurrent) {
                // 结点是父结点的右结点，一直往上找，找到第一个结点为parent左子结点的结点，此时的parent即为next
                pCurrent = pParent;
                pParent = pParent.next;
            }
            // 如果结点是父结点的左子结点，next即为parent
            next = pParent;
        }
        return next;
    }
}
