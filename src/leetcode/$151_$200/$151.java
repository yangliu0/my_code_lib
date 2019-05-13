package leetcode.$151_$200;

/**
 * Created by Yang Liu on 2019/4/16
 */

// Reverse Words in a String
public class $151 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        char[] a = s.toCharArray();
        int n = a.length;

        // 翻转整个字符串
        reverse(a, 0, n - 1);

        // 翻转每个词
        reverseWords(a, n);

        // 去掉首位多余的空格
        return cleanSpaces(a, n);
    }

    private void reverse(char[] a, int start, int end) {
        int i = start, j = end;
        char tmp;
        while (i < j) {
            tmp = a[i];
            a[i++] = a[j];
            a[j--] = tmp;
        }
    }

    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') {
                // 跳过空格
                ++i;
            }

            while (j < i || j < n && a[j] != ' ') {
                // 跳过字符
                ++j;
            }

            reverse(a, i, j - 1);
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            // 跳过空格
            while (j < n && a[j] == ' ') {
                ++j;
            }

            // 保留字符
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++];
            }

            // 跳过空格
            while (j < n && a[j] == ' ') {
                ++j;
            }

            // 两个词之间保留一个空格
            if (j < n) {
                a[i++] = ' ';
            }
        }

        return new String(a).substring(0, i);
    }

    public static void main(String[] args) {
        $151 solution = new $151();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
