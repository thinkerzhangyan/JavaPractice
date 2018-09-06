package jianzhioffer;

import java.util.ArrayList;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution42B {

    public ArrayList<Integer> resolve(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0) {
            return list;
        }

        int head = 0;
        int tail = array.length - 1;

        int curSum = 0;

        while (head < tail) {

            curSum = array[head] + array[tail];

            if (curSum == sum) {
                list.add(array[head]);
                list.add(array[tail]);
                return list;
            } else if (curSum < sum) {
                head++;
            } else {
                tail--;
            }

        }

        return list;
    }

}
