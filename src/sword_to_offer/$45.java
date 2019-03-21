package sword_to_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Yang Liu on 2019/3/17
 */

// 把数组排成最小的数
public class $45 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int n : numbers) {
            arrayList.add(n);
        }

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });

        for (int n : arrayList) {
            stringBuilder.append(n);
        }
        return stringBuilder.toString();
    }
}
