package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des 构建乘积数组
 */
public class Solution51 {

    public int[] multiply(int[] A) {

        int[] B = new int[A.length];

        if(A==null||A.length<=1)
            return B;

        int len = A.length;

        int[] C = new int[len];
        int[] D = new int[len];

        C[0]=D[len-1]=1;

        for(int i=1;i<len;i++){
            C[i]=C[i-1]*A[i-1];
        }

        for(int i=len-2;i>=0;i--){
            D[i]=D[i+1]*A[i+1];
        }

        for(int i=0;i<len;i++){
            B[i]=C[i]*D[i];
        }

        return B;

    }

}
