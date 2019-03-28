package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 0~n-1中缺失的数字
public class $53_1 {
    public int getMissingNumber(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] != mid) {
                if (mid == 0 || array[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == array.length - 1) {
            return array.length - 1;
        }

        return -1;
    }
}
