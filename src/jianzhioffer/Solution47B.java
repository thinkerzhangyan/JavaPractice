package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/22
 * @des
 */
public class Solution47B {

    int result = 0;

    public int Sum_Solution(int n) {

        if (n < 0) {
            return -1;
        }

        add(n);

        return result;
    }

    private boolean add(int n) {

        result += n;

        return n != 0 && add(n - 1);
    }

}
