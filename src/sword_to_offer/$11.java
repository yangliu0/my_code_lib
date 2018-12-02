package sword_to_offer;

/**
 * Created by Yang Liu on 2018/12/2
 */

// 旋转数组的最小数字
public class $11 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int left = 0, right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = left + ((right - left) >> 1);
            if (array[left] == array[mid] && array[mid] == array[right]) {
                // 3个数字相同，只能顺序查找，例如 1 0 1 1 1
                return minInOrder(array, left, right);
            }

            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }

    private int minInOrder(int[] array, int left, int right) {
        int minNum = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (minNum > array[i]) {
                minNum = array[i];
            }
        }
        return minNum;
    }
}
