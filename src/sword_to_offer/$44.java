package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/17
 */

// 数字序列中某一位的数字
public class $44 {
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }

        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits) {
                return digitsAtIndex(index, digits);
            }
            index -= digits * numbers;
            digits++;
        }
    }

    // 得到m位的数字有多少个
    private int countOfIntegers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    // 找到index位的数
    private int digitsAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    // 找到第一个m位数
    private int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int) Math.pow(10, digits - 1);
    }
}
