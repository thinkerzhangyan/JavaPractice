package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 整数中1出现的次数（从1到n整数中1出现的次数）
 */
public class Solution31 {

    public int numberOfOneBetweenOneAndNA(int n) {

        int number = 0;

        for(int i=0;i<=n;i++) {
            number += numberOfOneInNumber(i);
        }

        return number;
    }

    private int numberOfOneInNumber(int i) {

        int number=0;

        while (i != 0) {
            if (i % 10 == 1) {
                number++;
            }
            i /= 10;
        }

        return number;
    }

}
