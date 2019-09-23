package leetcode.$51_$100;

/**
 * Created by Yang Liu on 2019/9/3
 */

// Word Search
public class $79 {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (dfs(board, y, x, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (y < 0 || x < 0 || y == board.length || x == board[0].length) {
            return false;
        }

        if (board[y][x] != word[i]) {
            return false;
        }

        board[y][x] ^= 256;
        boolean exist = dfs(board, y + 1, x, word, i + 1)
                || dfs(board, y - 1, x, word, i + 1)
                || dfs(board, y, x - 1, word, i + 1)
                || dfs(board, y, x + 1, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }
}
