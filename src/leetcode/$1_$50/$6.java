package $1_$50;

public class $6 {
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        if (numRows == 1) return s;
        int step1, step2;
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            step1 = (numRows - i - 1) * 2;
            step2 = 2 * i;
            int pos = i;
            if (pos < len) result.append(s.charAt(pos));
            while (true) {
                pos += step1;
                if (pos >= len) break;
                if (step1 > 0) {
                    result.append(s.charAt(pos));
                }

                pos += step2;
                if (pos >= len) break;
                if (step2 > 0) {
                    result.append(s.charAt(pos));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        $6 solution = new $6();
        String result = solution.convert(s, numRows);
        System.out.printf("%s", result);
    }
}
