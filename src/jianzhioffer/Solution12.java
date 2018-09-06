package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/12/6
 * @des 求n次方
 */
public class Solution12 {

    public double Power(double base, int exponent) throws Exception {

        if (exponent < 0) {

            if (base == 0) {
                throw new Exception("base=0&&exponet<0");
            }

            exponent = -exponent;

            return 1 / powerWithUnsignedExponent(base, exponent);

        } else {
            return powerWithUnsignedExponent(base, exponent);
        }

    }

    public double powerWithUnsignedExponent(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x01) == 1) {
            result *= base;
        }
        return result;

    }



}
