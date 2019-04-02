package leetcode.$301_$350;

/**
 * Created by Yang Liu on 2019/4/1
 */

// Reverse String
public class $344 {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
