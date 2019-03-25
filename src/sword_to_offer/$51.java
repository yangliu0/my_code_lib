package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/24
 */

// 数组中的逆序对
public class $51 {
    public int InversePairs(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            copy[i] = array[i];
        }

        int count = inversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private int inversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = (end - start) >> 1;
        int left = inversePairsCore(array, copy, start, start + mid) % 1000000007;
        int right = inversePairsCore(array, copy, start + mid + 1, end) % 1000000007;

        // 前半段最后一个数字下标
        int i = start + mid;
        // 后半段最后一个数字下标
        int j = end;

        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + mid + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy--] = array[i--];
                count += j - start - mid;
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i >= start; --i) {
            copy[indexCopy--] = array[i];
        }
        for (; j >= start + mid + 1; --j) {
            copy[indexCopy--] = array[j];
        }

        for (int s = start; s <= end; ++s) {
            array[s] = copy[s];
        }
        return (count + left + right) % 1000000007;
    }
}
