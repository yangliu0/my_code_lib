package leetcode.$351_$400;

import java.util.PriorityQueue;

/**
 * Created by Yang Liu on 2019/9/1
 */
// 378. Kth Smallest Element in a Sorted Matrix
public class $378 {

    public class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple t) {
            return this.val - t.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.peek().val;
    }
}
