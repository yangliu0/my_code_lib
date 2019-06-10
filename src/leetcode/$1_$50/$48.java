package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/5/17
 */

// 旋转图像
// Rotate Image
public class $48 {
    public void rotate(int[][] matrix) {
        // 转置矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 将矩阵左右对称变换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = tmp;
            }
        }
    }
}
