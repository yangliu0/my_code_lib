package leetcode.$701_$750;

import java.util.PriorityQueue;

/**
 * Created by Yang Liu on 2019/10/15
 */

// Swim in Rising Water
public class $718 {
    // 优先队列
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        visited[0][0] = true;
        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int i = info[0], j = info[1], max = info[2];
            for (int[] dir : dirs) {
                int newI = i + dir[0], newJ = j + dir[1];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= n) continue;
                if (!visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    int newMax = Math.max(max, grid[newI][newJ]);
                    if (newI == n - 1 && newJ == n - 1) {
                        return newMax;
                    }
                    pq.offer(new int[]{newI, newJ, newMax});
                }
            }
        }
        return 0;
    }


    // 二分法
    public int swimInWater1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int left = grid[0][0], right = n * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[n][n];
            if (hasPath(grid, n, 0, 0, visited, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean hasPath(int[][] grid, int n, int i, int j, boolean[][] visited, int time) {
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > time) {
            return false;
        }
        if (i == n - 1 && j == n - 1) {
            return true;
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (hasPath(grid, n, newI, newJ, visited, time)) {
                return true;
            }
        }

        return false;
    }
}
