package sword_to_offer;

/**
 * Created by Yang Liu on 2018/11/18
 */

// 替换空格
public class $5 {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() <= 0) {
            return "";
        }

        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        // 替换后字符串的长度
        int newLength = str.length() + 2 * spaceNum;
        int indexOld = str.length() - 1;
        int indexNew = newLength - 1;
        str.setLength(newLength);

        // 从后往前替换，O(n)
        while (indexOld >= 0 && indexNew > indexOld) {
            if (str.charAt(indexOld) == ' ') {
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            } else {
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
            indexOld--;
        }
        return str.toString();
    }
}
