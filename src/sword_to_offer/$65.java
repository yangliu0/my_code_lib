package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/10
 */

// 不用加减乘除做加法
public class $65 {
    public int Add(int num1,int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;
    }
}
