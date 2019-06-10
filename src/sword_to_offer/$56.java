package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 数组中只出现一次的数字
public class $56 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }

        int resultOR = 0;
        for (int i = 0; i < array.length; ++i) {
            resultOR ^= array[i];
        }

        int indexBit1 = 0;
        while ((resultOR & 1) == 0) {
            resultOR >>= 1;
            indexBit1++;
        }

        num1[0] = 0;
        num2[0] = 0;

        for (int j = 0; j < array.length; ++j) {
            if (isBit1(array[j], indexBit1)) {
                num1[0] ^= array[j];
            } else {
                num2[0] ^= array[j];
            }
        }
    }

    private boolean isBit1(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 0x01) == 1;
    }
}
