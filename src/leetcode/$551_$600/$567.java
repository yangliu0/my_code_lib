package leetcode.$551_$600;

/**
 * Created by Yang Liu on 2018/11/16
 */

// Permutation in String
public class $567 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZeros(count)) {
            return true;
        }

        // s2中只取s1长度的部门进行计算，超出窗口的部分需要恢复
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZeros(count)) {
                return true;
            }
        }
        return false;
    }

    private boolean allZeros(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "cd", s2 = "acdb";
        $567 solution = new $567();
        System.out.print(solution.checkInclusion(s1, s2));
    }
}
