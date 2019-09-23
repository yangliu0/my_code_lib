package leetcode.$301_$350;

/**
 * Created by Yang Liu on 2019/9/6
 */

// Burst Balloons
public class $312 {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) {
                arr[n++] = x;
            }
        }
        arr[0] = arr[n++] = 1;
        return 1;
    }
}
