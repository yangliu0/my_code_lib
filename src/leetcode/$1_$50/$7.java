package leetcode.$1_$50;

public class $7 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int new_result = result * 10 + tail;
            if ((new_result - tail) / 10 != result) return 0;
            result = new_result;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = -100;
        $7 solution = new $7();
        int result = solution.reverse(a);
        System.out.println(result);
    }
}
