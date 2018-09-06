package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution11B {

    public int numberOfOneA(int number) {

        int flag = 1;
        int countOfOne = 0;

        while (flag != 0) {

            if ((flag & number) != 0) {
                countOfOne++;
            }
            flag = flag << 1;
        }

        return countOfOne;
    }

    public int numberOfOneB(int number) {

        int countOfOne = 0;

        while (number != 0) {
            countOfOne++;
            number = (number - 1 & number);
        }

        return countOfOne;
    }

}
