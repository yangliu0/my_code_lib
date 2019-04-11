package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/10
 */

// 股票的最大利润
public class $63 {
    public int maxDiff(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return 0;
        }

        int min = numbers[0];
        int maxDiff = numbers[1] - min;

        for (int i = 2; i < numbers.length; ++i) {
            if (numbers[i - 1] < min) {
                min = numbers[i - 1];
            }

            int currDiff = numbers[i] - min;
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
            }
        }

        return maxDiff;
    }
}
