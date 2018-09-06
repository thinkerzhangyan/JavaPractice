package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 和最大的连续子数组
 */
public class Solution30A {

    //找出和最大的子数组
    public List<Integer> FindGreatestArrayOfSubArray(int[] array) {

        List<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0)
            return list;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;



        for (int i = 0; i < array.length; i++) {

            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }

            if (maxSum < sum) {
                maxSum = sum;
            }

        }

        return list;
    }


}
