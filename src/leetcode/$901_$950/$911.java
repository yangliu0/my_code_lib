package leetcode.$901_$950;

import java.util.*;

/**
 * Created by Yang Liu on 2019/10/19
 */

// Online Election
public class $911 {
    public int[] times;

    Map<Integer, Integer> map = new HashMap<>();

    public $911(int[] persons, int[] times) {
        this.times = times;
        int n = persons.length, leader = -1;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (count.containsKey(persons[i])) {
                count.put(persons[i], count.get(persons[i]) + 1);
            } else {
                count.put(persons[i], 1);
            }
            if (i == 0 || count.get(persons[i]) >= count.get(leader)) {
                leader = persons[i];
            }
            map.put(times[i], leader);
        }
    }

    public int q(int t) {
        int index = binarySearch(times, 0, times.length - 1, t);
        return index < 0 ? map.get(times[-index - 2]) : map.get(times[index]);
    }

    public int binarySearch(int[] times, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (times[mid] < target) {
                left = mid + 1;
            } else if (times[mid] > target){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -(left + 1);
    }
}
