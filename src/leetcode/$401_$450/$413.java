package leetcode.$401_$450;

/**
 * Created by Yang Liu on 2019/9/5
 */

// Arithmetic Slices
public class $413 {
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr++;
                res += curr;
            } else {
                curr = 0;
            }
        }
        return res;
    }
}
