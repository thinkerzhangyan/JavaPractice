package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/12/4
 * @des 位运算，计算数字二进制表示中1的个数
 */
public class Solution11 {

    public static void main(String[] args) {

    }

    public static int numberOfOneA(int n) {

        int flag =1;

        int count=0;

        while (flag!=0) {

            if((n&flag)==1)
                count++;

            flag = flag << 1;
        }

        return count;
    }

    public static int numberOfOneB(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    public static int method(int number) {


        int count =0;

        while (number != 0) {
            count++;
            number = number & (number - 1);
        }

        return count;
    }


}
