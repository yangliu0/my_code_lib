package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 数组中唯一只出现一次的数字
public class $56_1 {
    public int findNumberAppearingOnce(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int[] bitSum = new int[32];
        for (int i = 0; i < numbers.length; ++i) {
            int bitMask = 1;
            for (int j = 31; j >= 0; --j) {
                int bit = numbers[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }

}
