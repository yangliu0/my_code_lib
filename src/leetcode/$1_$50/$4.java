package $1_$50;

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

}
