package sword_to_offer;

/**
 * Created by Yang Liu on 2019/4/13
 */

// 质因数分解
// 最大公约数
// 最小公倍数
public class primeFactor {
    // 质因数分解
    public void primeFactorDecomposition(int n) {
        for (int i = 2; i <= n; ++i) {
            while (n != i) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    n /= i;
                } else {
                    break;
                }
            }
        }

        System.out.printf("%d\n", n);
    }

    // 最大公约数
    public int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // 最小公倍数
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        primeFactor solution = new primeFactor();
        solution.primeFactorDecomposition(8);
        System.out.println(solution.gcd(12, 18));
        System.out.println(solution.lcm(2, 10));
    }
}
