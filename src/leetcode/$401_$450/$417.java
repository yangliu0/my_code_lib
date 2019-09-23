package leetcode.$401_$450;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yang Liu on 2019/9/6
 */

// Pacific Atlantic Water Flow
public class $417 {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacinic = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacinic, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(matrix, pacinic, Integer.MIN_VALUE, 0, j);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacinic[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || matrix[x][y] < height) {
            return;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(matrix, visited, matrix[x][y], x + dir[0], y + dir[1]);
        }
    }
}
