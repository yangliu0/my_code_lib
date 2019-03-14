package sword_to_offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Yang Liu on 2019/3/13
 */

// 字符串的排列
public class $38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        Permutation(chars, new ArrayList<>(), res, new boolean[chars.length]);
        return res;
    }

    private void Permutation(char[] chars, ArrayList<Character> tmpRes, ArrayList<String> res, boolean[] used) {
        if (tmpRes.size() == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : tmpRes) {
                sb.append(c);
            }
            res.add(sb.toString());
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (used[i] || i > 0 && chars[i - 1] == chars[i] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                tmpRes.add(chars[i]);
                Permutation(chars, tmpRes, res, used);
                used[i] = false;
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }

}
