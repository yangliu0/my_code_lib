package leetcode.$101_$150;

/**
 * Created by Yang Liu on 2019/4/7
 */

// Valid Palindrome
public class $125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        char cLeft, cRight;
        while (left <= right) {
            cLeft = s.charAt(left);
            cRight = s.charAt(right);
            if (!Character.isLetterOrDigit(cLeft)) {
                ++left;
            } else if (!Character.isLetterOrDigit(cRight)) {
                --right;
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
