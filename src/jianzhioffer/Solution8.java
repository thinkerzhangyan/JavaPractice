package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 跳台阶（斐波那契数列）
 */
public class Solution8 {

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


}
