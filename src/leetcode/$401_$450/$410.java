package leetcode.$401_$450;

/**
 * Created by Yang Liu on 2019/4/11
 */

// Split Array Largest Sum
public class $410 {

    // 二分查找法
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        if (m == 1) {
            return (int)sum;
        }

        long l = max, r = sum;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }

    private boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                ++count;
                // mid太小，分割数大于m
                if (count > m) {
                    return false;
                }
            }
        }
        // 分割成功，每一个子部分的sum都小于mid
        return true;
    }
}
