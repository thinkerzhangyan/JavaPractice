package jianzhioffer;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangyan
 * @date 2018/1/22
 * @des
 */
public class Solution50B {

    public static void main(String[] args) {

        System.out.println(duplicate(new int[]{1, 2, 3, 4, 4, 4, 4, 4, 5, 6, 7, 7, 8}));

    }

    public static int duplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }


        int lo = 0;
        int hi = nums.length - 1;

        int mid = 0;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int count = 0;
            for (Integer num : nums) {

                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;

    }


}


