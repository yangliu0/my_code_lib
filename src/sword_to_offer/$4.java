package sword_to_offer;

/**
 * Created by Yang Liu on 2018/11/7
 */

// 二维数组中的查找

public class $4 {
    public static boolean Find(int target, int[][] array) {
        boolean found = false;

        if (array != null && array.length > 0 && array[0].length > 0) {
            int row_num = array.length;
            int column_num = array[0].length;
            int row = 0;
            int column = column_num - 1;
            while (row < row_num && column >= 0) {
                if (array[row][column] == target) {
                    found = true;
                    break;
                } else if (array[row][column] > target) {
                    column--;
                } else {
                    row++;
                }
            }
        }
        return found;
    }
}
