package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 连续子数组的最大和
 */
public class Solution30B {

    public int FindGreatestSumOfSubArray(int[] array) {


        if (array == null || array.length == 0) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;

        int curSum = 0;


        for (int i=1;i<array.length;i++) {

            if (curSum < 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;

    }
}
