package jianzhioffer;

import shujujiegou.KdTree;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 数字在排序数组中出现的次数
 */
public class Solution37B {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(array,3));
    }

    public static int getNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLaskK(array, k, 0, array.length - 1);

        if (firstK > -1 && lastK > -1) {
            return lastK - firstK + 1;
        }

        return 0;
    }

    private static int getFirstK(int[] array, int k, int head, int tail) {

        if (head > tail) {
            return -1;
        }

        int mid = head + (tail - head) / 2;

        if (array[mid] == k) {
            if (mid == 0 || (mid > 0 && array[mid - 1] != k)) {
                return mid;
            } else {
                tail = mid - 1;
            }
        } else if (array[mid] < k) {
            head = mid + 1;
        } else {
            tail = mid - 1;
        }

        return getFirstK(array, k, head, tail);
    }

    private static int getLaskK(int[] array, int k, int head, int tail) {

        if (head > tail) {
            return -1;
        }

        int mid = head + (tail - head) / 2;

        if (array[mid] == k) {

            if (mid == array.length - 1 || (mid < array.length-1 && array[mid+1] != k)) {
                return mid;
            } else {
                head = mid + 1;
            }

        } else if (array[mid] < k) {
            head = mid + 1;
        } else {
            tail = mid - 1;
        }

        return getLaskK(array,k,head,tail);
    }


}
