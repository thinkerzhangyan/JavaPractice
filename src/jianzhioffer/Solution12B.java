package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution12B {
    public double power(double base, int exponent) throws Exception {

        if (base == 0 && exponent <= 0) {
            throw new Exception("base == 0 && exponent <= 0");
        }

        if (exponent < 0) {
            exponent = -exponent;
            return 1/powerHelper(base, exponent);
        } else {
            return powerHelper(base, exponent);
        }
    }

    public double powerHelper(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        double result = powerHelper(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x01) != 0) {
            result *= base;
        }
        return result;
    }
}
