package sword_to_offer;

import java.util.ArrayList;

/**
 * Created by Yang Liu on 2019/3/4
 */

// 顺时针打印矩阵
public class $29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        while (row > start * 2 && col > start * 2) {
            printMatrixInCircle(matrix, row, col, start, arrayList);
            start++;
        }
        return arrayList;
    }

    private void printMatrixInCircle(int[][] matrix, int row, int col, int start, ArrayList<Integer> arrayList) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            arrayList.add(number);
        }

        // 从上到下打印一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = matrix[i][endX];
                arrayList.add(number);
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = matrix[endY][i];
                arrayList.add(number);
            }
        }

        // 从下到上打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = matrix[i][start];
                arrayList.add(number);
            }
        }
    }
}
