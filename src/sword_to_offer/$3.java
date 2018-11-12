package sword_to_offer;

/**
 * Created by Yang Liu on 2018/11/1
 */

// 数组中重复的数字


public class $3 {
    // 找出数组中重复的数字
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                // 对比当前数与index为当前数的数，如果相等则重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }

                // 交换当前数与index为当前数的数
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }


    // 不修改数组找出重复数字
    public static int getDuplication(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            return -1;
        }

        int start = 1;
        int end = length - 1;
        while (start <= end) {
            // 二分统计思想
            int mid = start + ((end - start) >> 1);
            int count = countRange(numbers, length, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
//        int[] numbers = {2, 1, 3, 0, 4};
        int[] duplication = new int[1];
        boolean res = duplicate(numbers, numbers.length, duplication);
        if (res) {
            System.out.println(duplication[0]);
        }

        int res1 = getDuplication(numbers, numbers.length);
        System.out.println(res1);
    }
}
