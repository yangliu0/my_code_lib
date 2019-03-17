package sword_to_offer;

import java.util.Arrays;

/**
 * Created by Yang Liu on 2019/3/14
 */

// 1~n整数中1出现的次数
public class $43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        String strN = String.valueOf(n);
        char[] str = strN.toCharArray();

        return numberOf1(str);
    }

    private int numberOf1(char[] str) {
        if (str == null || str[0] < '0' || str[0] > '9') {
            return 0;
        }

        int first = Character.getNumericValue(str[0]);
        int length = str.length;

        if (first == 0 && length == 1) {
            return 0;
        }
        if (first > 0 && length == 1) {
            return 1;
        }

        // 假设strN是21345
        // numberOfFirstDigit是数字10000~19999的第一位中的数目
        int numberOfFirstDigit = 0;
        if (first > 1) {
            numberOfFirstDigit = powerBase10(length - 1);
        } else if (first == 1) {
            char[] tempChar = Arrays.copyOfRange(str, 1, length);
            String tempStr = String.valueOf(tempChar);
            numberOfFirstDigit = Integer.parseInt(tempStr) + 1;
        }

        int numOtherDigit = first * (length - 1) * powerBase10(length - 2);

        int numRecursive = numberOf1(Arrays.copyOfRange(str, 1, length));

        return numberOfFirstDigit + numOtherDigit + numRecursive;
    }

    private int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }
}
