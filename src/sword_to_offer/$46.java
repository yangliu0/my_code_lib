package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/17
 */

// 把数组翻译成字符串
public class $46 {
    public static int getTranslation(int number) {
        if (number < 0) {
            return 0;
        }

        char[] numbers = String.valueOf(number).toCharArray();
        return getTranslationCount(numbers);
    }

    private static int getTranslationCount(char[] numbers) {
        int length = numbers.length;
        int[] counts = new int[length];
        int count = 0;

        for (int i = length - 1; i >= 0; i--) {
            count = 0;
            if (i < length - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }

            if (i < length - 1) {
                int digit1 = numbers[i] - '0';
                int digit2 = numbers[i + 1] - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }

    public static void main(String[] args) {
        int count = getTranslation(12258);
        System.out.println(count);
    }
}
