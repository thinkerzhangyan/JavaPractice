package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des 求1+2+3+...+n
 */
public class Solution47 {

    private int sum = 0;

    public int Sum_Solution(int n) {

        if (n < 0) {
            return -1;
        }

        add(n);

        return sum;
    }

    public boolean add(int n) {

        sum += n;

        return n!=0&&add(n-1);
    }

}
