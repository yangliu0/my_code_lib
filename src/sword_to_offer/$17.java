package sword_to_offer;

import java.util.Arrays;

/**
 * Created by Yang Liu on 2019/2/27
 */
// 打印从1到最大的n位数
public class $17 {
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        Arrays.fill(number, '0');
        while (!increment(number)) {
            printNumber(number);
        }
    }

    public static boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ((int) '0' + nSum);
                }
            } else {
                number[i] = (char) ((int) '0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    public static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;

        for (int i = 0; i < nLength; i++) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }

            if (!isBeginning0) {
                System.out.printf("%c", number[i]);
            }
        }
        System.out.println();
    }


    // 全排列法
    public static void print1ToMaxOfNDigits1(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        Arrays.fill(number, '0');

        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + (int) '0');
            print1ToMaxOfDigitsRecursively(number, n, 0);
        }
    }

    public static void print1ToMaxOfDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + (int) '0');
            print1ToMaxOfDigitsRecursively(number, length, index + 1);
        }
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits1(3);
    }
}
