package $1_$50;

public class $9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (x == rev) || (x == rev / 10);
    }

    public static void main(String[] args) {
        $9 solution = new $9();
        boolean result = solution.isPalindrome(123321);
        System.out.println(result);
    }
}
