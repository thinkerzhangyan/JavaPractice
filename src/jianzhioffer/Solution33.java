package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 丑数
 */
public class Solution33 {

    public static void main(String[] args) {
        System.out.println(getTheNthUglyNumberA(10));
    }

    //时间复杂度过大的方法
    public static int getTheNthUglyNumberA(int n) {

        if (n <= 0) {
            return 0;
        }

        int result=1;
        int index =1;

        while (index != n) {
            result++;
            if (isUgly(result)) {
                index++;
            }
        }

        return result;
    }

    //以空间换时间的方法
    public static int getTheNthUglyNumberB(int n) {

        if (n <= 0) {
            return 0;
        }

        int[] uglyNumers = new int[n];

        int p2=0;
        int p3=0;
        int p5=0;

        uglyNumers[0] = 1;

        for (int i=1;i<n;i++) {
            uglyNumers[i] = min(uglyNumers[p2] * 2, uglyNumers[p3]*3, uglyNumers[p5]*5);
            while(uglyNumers[p2]*2<=uglyNumers[i]) p2++;
            while(uglyNumers[p3]*3<=uglyNumers[i]) p3++;
            while(uglyNumers[p5]*5<=uglyNumers[i]) p5++;
        }


        return uglyNumers[n - 1];
    }

    private static int min(int number2, int number3, int number5) {
        int tmp = number2 < number3 ? number2 : number3;
        return tmp < number5 ? tmp : number5;
    }


    private static boolean isUgly(int result) {

        while (result % 2 == 0) {
            result /= 2;
        }

        while (result % 3 == 0) {
            result /= 3;
        }

        while (result % 5 == 0) {
            result /= 5;
        }

        return result==1?true:false;

    }

}
