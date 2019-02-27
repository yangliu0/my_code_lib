package sword_to_offer;

/**
 * Created by Yang Liu on 2018/12/3
 */

// 数值的整数次方
public class $16 {
    boolean gInvalidInput = false;

    public double Power(double base, int exponent) {
        gInvalidInput = false;

        if (equal(base, 0.0) && exponent < 0) {
            gInvalidInput = true;
            return 0.0;
        }

        long absExponent = (long)exponent;
        if (absExponent < 0) {
            absExponent = (long)(-exponent);
        }

        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double powerWithUnsignedExponent(double base, long absExponent) {
        if (absExponent == 0) {
            return 1.0;
        }
        if (absExponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, absExponent >> 1);
        result *= result;
        if ((absExponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }

    private boolean equal(double num1, double num2) {
        return num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001;
    }
}
