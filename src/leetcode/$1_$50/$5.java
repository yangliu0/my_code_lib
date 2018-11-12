package leetcode.$1_$50;

public class $5 {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.length() - i <= (end - start) / 2) break;
            int j = i, k = i;
            while (k < s.length()-1 && s.charAt(k) == s.charAt(k+1)) k++;
            i = k+1;
            while (k < s.length()-1 && j > 0 && s.charAt(k+1) == s.charAt(j-1)) {
                k++;
                j--;
            }
            if (k-j+1 > end - start) {
                start = j;
                end = k+1;
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        String s = "abacab";
        $5 solution = new $5();
        String result = solution.longestPalindrome(s);
        System.out.printf("%s", result);
    }
}
