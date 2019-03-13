package sword_to_offer;

import java.util.Random;

/**
 * Created by Yang Liu on 2019/3/12
 */

// 数组中出现次数超过一半的数字
public class $39 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int mid = array.length >> 1;
        int start = 0, end = array.length - 1;
        int index = partition(array, array.length, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
                index = partition(array, array.length, start, end);
            }
            if (index < mid) {
                start = index + 1;
                index = partition(array, array.length, start, end);
            }
        }
        int result = array[mid];
        if (!checkMoreThanHalf(array, array.length, result)) {
            result = 0;
        }
        return result;
    }

    private int partition(int[] array, int length, int start, int end) {
        if (array == null || length <= 0 || start < 0 || end >= length) {
            return -1;
        }

        int index = new Random().nextInt(end - start + 1) + start;
        swap(array, index, end);

        int small = start - 1;
        for (index = start; index < end; index++) {
            if (array[index] < array[end]) {
                small++;
                swap(array, small, index);
            }
        }
        small++;
        swap(array, small, end);
        return small;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean checkMoreThanHalf(int[] array, int length, int result) {
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == result) {
                times++;
            }
        }

        boolean moreThanHalf = true;
        if (times * 2 <= length) {
            moreThanHalf = false;
        }
        return moreThanHalf;
    }

    // 第二种思路，通过计数来处理
    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int times = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result == array[i]) {
                times++;
            } else {
                times--;
                if (times == 0) {
                    result = array[i];
                    times++;
                }
            }
        }
        if (!checkMoreThanHalf(array, array.length, result)) {
            result = 0;
        }
        return result;
    }
}
