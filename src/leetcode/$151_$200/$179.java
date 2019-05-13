package leetcode.$151_$200;

import java.util.*;

/**
 * Created by Yang Liu on 2019/4/17
 */

// Largest Number
public class $179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "";
        }

        String[] strNum = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strNum[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        };

        Arrays.sort(strNum, comp);

        if (strNum[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (String s : strNum) {
            res.append(s);
        }

        return res.toString();
    }
}
