package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/25
 */

// 翻转单词顺序
public class $58 {
    public String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] splitTemp;
        char[] ch = str.toCharArray();
        reverse(ch);
        String[] strs = String.valueOf(ch).split(" ");
        for (int i = 0; i < strs.length; i++) {
            splitTemp = strs[i].toCharArray();
            reverse(splitTemp);
            stringBuilder.append(splitTemp);
            if (i != strs.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    private void reverse(char[] ch) {
        if (ch == null || ch.length <= 1) {
            return;
        }

        int begin = 0;
        int end = ch.length - 1;
        while (begin < end) {
            char temp = ch[begin];
            ch[begin] = ch[end];
            ch[end] = temp;
            ++begin;
            --end;
        }
    }
}
