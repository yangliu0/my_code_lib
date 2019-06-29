package sword_to_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yang Liu on 2019/6/16
 */

// 字符流中第一个不重复的字符
public class $69 {
    private Queue<Character> data = new LinkedList<>();
    private int[] count = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {
        ++count[ch];
        if (count[ch] == 1) {
            data.offer(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!data.isEmpty() && count[data.peek()] >= 2) {
            data.poll();
        }
        if (data.isEmpty()) {
            return '#';
        }
        return data.peek();
    }
}
