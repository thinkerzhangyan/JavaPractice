package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/12/6
 * @des 不用加减乘除做加法
 */
public class Solution48 {

    public int AddA(int num1, int num2) {

        int sum=0;
        int carry=0;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;

        } while (num2 != 0);

        return sum;

    }

    public static int AddB(int num1, int num2) {

        int sum=0;

        do {

            sum = num1 ^ num2;

            num2 = (num1 & num2) << 1;

            num1 = num2;

            num2 = sum;

        } while (num1 != 0);

        return sum;

    }
}
