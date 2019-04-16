package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/13
 */

// 把字符串转换成整数
public class $67 {
    boolean g_status = false;
    public int StrToInt(String str) {
        if (str == null || str.length() < 1) {
            g_status = true;
            return 0;
        }

        boolean negativeFlag = false;
        char[] ch = str.toCharArray();
        if (ch[0] == '-') {
            negativeFlag = true;
        }

        int sum = 0;
        for (int i = 0; i < ch.length; ++i) {
            if (i == 0 && (ch[i] == '+' || ch[i] == '-')) {
                continue;
            }

            if (ch[i] < '0' || ch[i] > '9') {
                g_status = true;
                return 0;
            }

            sum = sum * 10 + Character.getNumericValue(ch[i]);
        }

        return negativeFlag ? -sum : sum;
    }
}
