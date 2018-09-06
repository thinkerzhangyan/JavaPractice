package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 斐波那契数列
 */
public class Solution7 {

    public static int FibonacciA(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return FibonacciA(n - 1) + FibonacciA(n - 2);
    }

    public static int FibonacciB(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int fibA = 0;
        int fibB = 1;

        int fibN = 0;

        for (int i = 2; i <= n; i ++) {
            fibN = fibA + fibB;
            fibA = fibB;
            fibB = fibN;
        }
        return fibN;
    }

}
