package leetcode.$1_$50;

// Median of Two Sorted Arrays
public class $4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // 保持num2比较短
        if (n1 < n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lo = 0, hi = 2 * n2;
        while (lo <= hi) {
            int mid2 = lo + (hi - lo) / 2;
            int mid1 = n1 + n2 - mid2;

            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == 2 * n1) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double R2 = (mid2 == 2 * n2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (L1 > R2) {
                lo = mid2 + 1;
            } else if (L2 > R1) {
                hi = mid2 - 1;
            } else {
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
        }
        return -1;
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            // 确保nums1长度小于nums2长度
            return findMedianSortedArrays1(nums2, nums1);
        }

        int iMin = 0;
        int iMax = m;
        int haftLen = (m + n + 1) / 2;

        while (iMin <= iMax) {
            // 初始从nums1的中间分隔
            int i = (iMin + iMax) / 2;

            // 确保条件 i + j = m + n - i - j
            int j = haftLen - i;

            // i太小
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin += 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax -= 1;
            } else {
                // 确保条件 nums1[i - 1] <= B[j] && nums2[j - 1] <= nums1[i]
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
