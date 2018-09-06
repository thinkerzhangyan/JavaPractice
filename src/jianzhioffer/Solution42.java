package jianzhioffer;

import java.util.ArrayList;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 和为S的两个数字
 */
public class Solution42 {

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0) {
            return list;
        }

        int front = 0;
        int behind = array.length - 1;

        while (behind > front) {

            if (sum == array[front] + array[behind]) {
                list.add(array[front]);
                list.add(array[behind]);
                return list;
            } else if (sum < array[front] + array[behind]) {
                behind--;
            } else {
                front++;
            }
        }

        return list;
    }

}
