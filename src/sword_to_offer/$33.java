package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/5
 */

// 二叉树的后序遍历序列
public class $33 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        return VerifySquenceOfBST(sequence, 0, sequence.length);

    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int length) {
        int root = sequence[length - 1];

        // 二叉树中左子树的节点值小于根节点的值
        int i = start;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        // 二叉树中右节点的值大于根节点的值
        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 判断左子树是不是二叉树
        boolean left = true;
        if (i > 0) {
            left = VerifySquenceOfBST(sequence, 0, i);
        }

        // 判断右子树是不是二叉树
        boolean right = true;
        if (i < length - 1) {
            right = VerifySquenceOfBST(sequence, i, length - i - 1);
        }

        return left && right;
    }
}
