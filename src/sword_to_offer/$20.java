package sword_to_offer;

/**
 * Created by Yang Liu on 2019/2/28
 */

// 表示数值的字符串
public class $20 {
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        // str中存在0-9数字时，返回true
        return start < index;
    }
}
