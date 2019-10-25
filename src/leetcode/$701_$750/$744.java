package leetcode.$701_$750;

/**
 * Created by Yang Liu on 2019/10/22
 */
public class $744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (target >= letters[n - 1]) {
            target = letters[0];
        } else {
            target++;
        }

        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid;
            } else {
                return letters[mid];
            }
        }
        return letters[left];
    }
}
