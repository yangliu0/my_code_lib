package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/10
 */

// 求1+2+...+n
public class $64 {
    public int Sum_Solution(int n) {
        int result = 0;
        int a = 1;
        boolean value = (n != 0) && (a == (result = Sum_Solution(n - 1)));
        result += n;
        return result;
    }
}
