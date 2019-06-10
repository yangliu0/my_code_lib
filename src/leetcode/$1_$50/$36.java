package leetcode.$1_$50;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yang Liu on 2019/5/18
 */

// Valid Sudoku
public class $36 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!set.add(number + " in row " + i)
                            || !set.add(number + " in column " + j)
                            || !set.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
