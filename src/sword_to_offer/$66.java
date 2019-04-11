package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/10
 */

// 构建乘积数组
public class $66 {
    public int[] multiply(int[] A) {
        if (A == null || A.length <= 0) {
            return null;
        }

        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; ++i) {
            B[i] = A[i - 1] + B[i - 1];
        }

        int temp = 1;
        for (int j = len - 2; j >= 0; --j) {
            temp *= A[j + 1];
            B[j] *= temp;
        }

        return B;
    }
}
