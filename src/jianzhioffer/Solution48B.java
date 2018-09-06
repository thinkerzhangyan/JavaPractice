package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution48B {

    public int add(int a, int b) {

        int sum = 0;

        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a=sum;
        }

        return a;
    }

}
