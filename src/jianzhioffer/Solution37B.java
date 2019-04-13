package jianzhioffer;

import shujujiegou.KdTree;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 数字在排序数组中出现的次数
 */
public class Solution37B {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(array, 3));
    }

    public static int getNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return -1;
        }


        int fisrtOfK = getFirstOfK(array, 0, array.length - 1, k);

        int lastOfK = getLastOfK(array, 0, array.length - 1, k);

        if (fisrtOfK != -1 && lastOfK != -1) {
            return lastOfK - fisrtOfK + 1;
        }

        return -1;

    }


    private static int getFirstOfK(int[] array, int lo, int hi, int k) {

        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (array[mid] == k) {

            if (mid == 0 || (array[mid - 1] != k)) {
                return mid;
            } else {
                hi = mid - 1;
            }

        } else if (array[mid] < k) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }


        return getFirstOfK(array, lo, hi, k);
    }

    private static int getLastOfK(int[] array, int lo, int hi, int k) {

        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (array[mid] == k) {

            if ((mid == array.length - 1) || (array[mid + 1] != k)) {
                return mid;
            } else {
                lo = mid + 1;
            }

        } else if (array[mid] < k) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }

        return getLastOfK(array, lo, hi, k);
    }
}
