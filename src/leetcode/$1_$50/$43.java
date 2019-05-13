package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/4/16
 */

// Multiply Strings
// 字符串相乘
public class $43 {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        int d1, d2;
        for (int i = n1 - 1; i >= 0; --i) {
            for (int j = n2 - 1; j >= 0; --j) {
                d1 = num1.charAt(i) - '0';
                d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }

        int carry = 0;
        int tmp;
        for (int i = n1 + n2 - 1; i >= 0; --i) {
            tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }

        StringBuilder res = new StringBuilder();
        for (int n : products) {
            res.append(n);
        }

        while (res.length() != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
