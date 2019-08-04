package leetcode.$51_$100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Liu on 2019/8/3
 */

// Permutation Sequence
public class $60 {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int[] fact = new int[n]; // 阶乘
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        // 因为index从0开始
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            sb.append(nums.get(index));
            nums.remove(index);
            k %= fact[i - 1];
        }
        return sb.toString();
    }
}
