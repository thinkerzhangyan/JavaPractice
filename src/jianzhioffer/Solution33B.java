package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution33B {


    public static void main(String[] args) {
        System.out.println(getTheNthUglyNumberA(10));
    }

    public static int getTheNthUglyNumberA(int n) {

        if (n <= 0) {
            return 0;
        }

        int times = 1;
        int number = 1;

        while (times != n) {

            number++;
            if (isUgly(number)) {
                times++;
            }

        }

        return number;

    }

    public static int getTheNthUglyNumberB(int n) {

        if (n <= 0) {
            return 0;
        }

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        int[] uglyNumberArray = new int[n];

        uglyNumberArray[0] = 1;

        for (int i = 1; i < n; i++) {
            uglyNumberArray[i] = min(uglyNumberArray[p2]*2, uglyNumberArray[p3]*3, uglyNumberArray[p5]*5);
            while (uglyNumberArray[p2] * 2 <= uglyNumberArray[i]) p2++;
            while (uglyNumberArray[p3] * 3 <= uglyNumberArray[i]) p3++;
            while (uglyNumberArray[p5] * 5 <= uglyNumberArray[i]) p5++;
        }

        return uglyNumberArray[n - 1];

    }

    private static int min(int p2, int p3, int p5) {
        int tmp = p2 < p3 ? p2 : p3;
        return tmp < p5 ? tmp : p5;
    }

    private static boolean isUgly(int n) {

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1 ? true : false;
    }
}

