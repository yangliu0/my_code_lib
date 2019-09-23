package leetcode.$201_$250;

// Kth Largest Element in an Array
public class $215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = partition(nums, left, right);
            if (mid < k) {
                left = mid + 1;
            } else if (mid > k) {
                right = mid - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (i < right && nums[++i] < nums[right]) ;
            while (j > left && nums[--j] > nums[right]) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
