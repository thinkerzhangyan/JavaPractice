package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution7810B {

    public int FibonacciA(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int fibA = 0;
        int fibB = 1;

        int finN = 0;

        for(int i=2;i<=n;i++) {
            finN = fibA + fibB;
            fibA = fibB;
            fibB = finN;
        }
        return finN;

    }

    public int FibonacciB(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return FibonacciB(n - 1) + FibonacciB(n - 2);
    }


    public int Jump(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int fibA = 1;
        int fibB =2;

        int fibN = 0;


        for(int i=3;i<=n;i++) {
            fibN = fibA + fibB;
            fibA=fibB;
            fibB = fibN;
        }

        return fibN;
    }

    public int JumpSuper(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int fibA = 1;
        int fibB =2;

        int fibN = 0;


        for(int i=3;i<=n;i++) {
            fibN = fibA + fibB;
            fibA=fibB;
            fibB = fibN;
        }

        return fibN;
    }

    public int RectCover(int n) {

        if (n == 0) {
            return 0;
        }else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int fibA =1;
        int fibB =2;

        int fibN =0;

        for(int i=3;i<=n;i++) {
            fibN = fibA + fibB;
            fibA=fibB;
            fibB = fibN;
        }

        return fibN;

    }

}
