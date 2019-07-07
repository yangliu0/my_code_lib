package leetcode.$1_$50;

/**
 * Created by Yang Liu on 2019/7/7
 */

// 报数
// Count and Say
public class $38 {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
}
