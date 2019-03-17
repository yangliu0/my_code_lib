package sword_to_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yang Liu on 2019/3/14
 */

// 数据流中的中位数
public class $41 {
    private int count;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int filterMaxNum = maxHeap.poll();
            minHeap.offer(filterMaxNum);
        } else {
            minHeap.offer(num);
            int filterMinNum = minHeap.poll();
            maxHeap.offer(filterMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
