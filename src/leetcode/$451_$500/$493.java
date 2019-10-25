package leetcode.$451_$500;

/**
 * Created by Yang Liu on 2019/10/21
 */

// Reverse Pairs
public class $493 {
    public int[] helper;

    public int reversePairs(int[] nums) {
        helper = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }

        merge(nums, left, mid, right);
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = nums[i];
        }
        int p1 = left, p2 = mid + 1;
        int i = left;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid || (p2 <= right && helper[p1] >= helper[p2])) {
                nums[i++] = helper[p2++];
            } else {
                nums[i++] = helper[p1++];
            }
        }
    }
}
