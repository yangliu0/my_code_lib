package leetcode.$601_$650;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Maximum Product of Three Numbers
public class $628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[0] * nums[1] * nums[n - 1];

        return a > b ? a : b;
    }

    // heap
    public int maximumProduct1(int[] nums) {
        PriorityQueue<Integer> poHeap = new PriorityQueue<>();
        PriorityQueue<Integer> neHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int num : nums) {
            poHeap.offer(num);
            neHeap.offer(num);
            if (poHeap.size() > 3) {
                poHeap.poll();
            }
            if (neHeap.size() > 2) {
                neHeap.poll();
            }
        }

        int res = 1, max = 0;
        while (!poHeap.isEmpty()) {
            max = poHeap.poll();
            res *= max;
        }

        while (!neHeap.isEmpty()) {
            max *= neHeap.poll();
        }

        return res > max ? res : max;
    }
}
