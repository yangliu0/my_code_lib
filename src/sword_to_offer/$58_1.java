package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 左旋转字符串
public class $58_1 {
    public String LeftRotateString(String str, int n) {
        if (str == null) {
            return str;
        }
        char[] result = str.toCharArray();
        int length = str.length();
        if (length > 0 && n > 0 && n < length) {
            int leftStart = 0;
            int leftEnd = n - 1;
            int rightStart = n;
            int rightEnd = length - 1;
            // 翻转前n个字符
            reverse(result, leftStart, leftEnd);
            // 翻转后面部分
            reverse(result, rightStart, rightEnd);
            // 翻转整个字符串
            reverse(result, 0, length - 1);
        }
        return String.valueOf(result);
    }

    private void reverse(char[] ch, int start, int end) {
        if (ch == null || ch.length <= 1) {
            return;
        }

        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        $58_1 solution = new $58_1();
        System.out.println(solution.LeftRotateString("abcdefg", 2));
    }
}
