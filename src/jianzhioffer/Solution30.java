package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 连续子数组的最大和
 */
public class Solution30 {

    public int FindGreatestSumOfSubArrayA(int[] array) {

        if (array == null || array.length == 0)
            return 0;

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

        return maxSum;
    }




}
