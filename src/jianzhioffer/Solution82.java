package jianzhioffer;

import java.util.HashMap;

/**
 * @author zhangyan
 * @date 2018/8/30
 * @des 一个数组中含有1001个元素，存放了1,2,3...1000和一个重复的数。
 * 只有唯一一个数是重复的，其它均只出现一次。要求设计一个算法找出这个重复的数，
 * 要求：每个数组元素只能访问一次。
 */
public class Solution82 {

    //1 O(N*N) 两层遍历

    //2 排序 O(nlogn)

    /****************使用辅助空间**********************/

    //3 利用Hash，时间复杂度O(N),空间复杂度O(N)
    public int duplicateA(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(numbers[i])) {
                return numbers[i];
            } else {
                hashMap.put(numbers[i], 1);
            }
        }

        return -1;
    }


    //4 利用bit-map
    //该方法使用了辅助空间
    public int duplicateB(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        BitMap bitMap = new BitMap(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            if (bitMap.contain(numbers[i])) {
                return numbers[i];
            } else {
                bitMap.add(numbers[i]);
            }
        }

        return -1;

    }

    /****************不使用辅助空间**********************/

    //剩下的解决方法主要参考自：https://blog.csdn.net/dongtingzhizi/article/details/8858981


    //5 最简单的方法是，先求出1...1000的和（用公式：n(n+1)/2）sum1，然后求出arr[0]...arr[1000]的和sum2，（sum2-sum1）便是要求的结果。该方法只用遍历数组一次即可。
    //该方法可能会导致溢出
    public int duplicateC(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int N = numbers.length - 1;

        int sum1 = N * (N + 1) / 2;

        int sum2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum2 += numbers[i];
        }

        return sum2 - sum1;

    }


    //6 利用公式：a ^ b ^ a = b
    public int duplicateD(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            res ^= i;
            res ^= numbers[i];
        }
        return res;

    }

    //7
    public int duplicateE(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        for (int i = 0; i < numbers.length; i++) {

            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    return numbers[i];
                }
                int tmp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = tmp;
            }

        }

        return -1;

    }


    // 8
    //
    // O(logN)  O(1)
    //
    // 思路
    //
    // https://www.jianshu.com/p/f0bec6ae99ee?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
    // http://www.cnblogs.com/grandyang/p/4843654.html
    //
    // 在区间[1, n]中搜索，首先求出中点mid，然后遍历整个数组，统计所有小于等于mid的数的个数，
    // 如果个数大于mid，则说明重复值在[mid+1, n]之间，反之，重复值应在[1, mid-1]之间，
    // 然后依次类推，直到搜索完成，此时的low就是我们要求的重复值，参见代码如下：
    //
    public int duplicateF(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (Integer a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }


    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5};


        Solution82 solution82 = new Solution82();


        System.out.println(solution82.duplicateA(numbers));
        System.out.println(solution82.duplicateB(numbers));
        System.out.println(solution82.duplicateC(numbers));
        System.out.println(solution82.duplicateD(numbers));
        System.out.println(solution82.duplicateE(numbers));
        System.out.println(solution82.duplicateF(numbers));

    }


}
