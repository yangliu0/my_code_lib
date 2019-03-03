package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/1
 */

// 调整数组顺序使奇数位于偶数前面
public class $21 {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // 也可以将判断抽象成一个函数，提高扩展性
            while (start < end && (array[start] & 0x1) != 0) {
                start++;
            }

            while (start < end && (array[end] & 0x1) == 0) {
                end--;
            }

            if (start < end) {
                swap(array, start, end);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
