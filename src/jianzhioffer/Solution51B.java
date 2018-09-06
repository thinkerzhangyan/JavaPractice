package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution51B {

    public int[] multiply(int[] A) {

        if (A == null || A.length <= 0) {

            return null;
        }

        int len = A.length;

        int[] B = new int[len];

        int[] C = new int[len];
        int[] D = new int[len];

        C[0] = D[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            C[i] = C[i - 1] * A[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i + 1];
        }

        for (int i = 0; i < len; i++) {
            B[i] = C[i] * D[i];
        }

        return B;
    }
}
