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

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0;i<array.length;i++) {
            if (sum <= 0) {
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
