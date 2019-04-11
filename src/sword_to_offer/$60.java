package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/28
 */

// n个骰子的点数
// 打印出s的所有可能的值出现的概率
public class $60 {
    // 递归方法
    private int gMaxValue = 6;

    public void printProbability(int number) {
        if (number < 1) {
            return;
        }

        int maxSum = number * gMaxValue;
        int[] nProbabilities = new int[maxSum - number + 1];

        probability(number, nProbabilities);

        int total = (int) Math.pow((double) gMaxValue, number);
        for (int i = number; i <= maxSum; ++i) {
            double ratio = (double) nProbabilities[i - number] / total;
            System.out.printf("%d:%f\n", i, ratio);
        }
    }

    private void probability(int number, int[] nProbabilities) {
        for (int i = 1; i <= gMaxValue; ++i) {
            probability(number, number, i, nProbabilities);
        }
    }

    private void probability(int original, int current, int sum, int[] nProbabilities) {
        if (current == 1) {
            nProbabilities[sum - original]++;
        } else {
            for (int i = 1; i <= gMaxValue; ++i) {
                probability(original, current - 1, i + sum, nProbabilities);
            }
        }
    }

    // 循环方法
    public void printProbability1(int number) {
        if (number < 1) {
            return;
        }

        int[][] nProbabilities = new int[2][gMaxValue * number + 1];
        int flag = 0;
        for (int i = 1; i <= gMaxValue; ++i) {
            nProbabilities[flag][i] = 1;
        }

        for (int k = 2; k <= number; ++k) {
            for (int i = 0; i < k; ++i) {
                nProbabilities[1 - flag][i] = 0;
            }

            for (int i = k; i <= gMaxValue * k; ++i) {
                nProbabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= gMaxValue; ++j) {
                    nProbabilities[1 - flag][i] += nProbabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(gMaxValue, number);
        for (int i = number; i <= gMaxValue * number; ++i) {
            double ratio = (double) nProbabilities[flag][i] / total;
            System.out.printf("%d:%f\n", i, ratio);
        }
    }

    public static void main(String[] args) {
        $60 solution = new $60();
        solution.printProbability1(6);
    }
}
