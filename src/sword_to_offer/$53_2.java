package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 数组中数值和下标相等的元素
public class $53_2 {
    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] == mid) {
                return mid;
            } else if (array[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
