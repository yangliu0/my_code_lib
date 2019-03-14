package sword_to_offer;

import java.util.*;

/**
 * Created by Yang Liu on 2019/3/13
 */

// 最小的k个数
public class $40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
            return list;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (pq.size() < k) {
                pq.add(input[i]);
            } else {
                int peek = pq.peek();
                if (input[i] < peek) {
                    pq.poll();
                    pq.add(input[i]);
                }
            }
        }

        list = new ArrayList<>(pq);
        Collections.sort(list);
        return list;
    }

    // 若可以改变数组顺序
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k <= 0 || k > input.length) {
            return list;
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, input.length, start, end);

        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, input.length, start, end);
            } else {
                start = index + 1;
                index = partition(input, input.length, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private int partition(int[] input, int n, int start, int end) {
        if (input == null || input.length <= 0 || start < 0 || end >= n) {
            return -1;
        }

        int index = new Random().nextInt(end - start + 1) + start;
        swap(input, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (input[index] < input[end]) {
                small++;
                swap(input, small, index);
            }
        }
        small++;
        swap(input, small, end);
        return small;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
