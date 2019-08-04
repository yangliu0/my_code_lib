package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/7/14
 */

// Trapping Rain Water
public class $42 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    res += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
