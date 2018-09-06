package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 数字在排序数组中出现的次数
 */
public class Solution37 {

    public int getNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);

        if (firstK > -1 && lastK > -1) {
            return lastK - firstK + 1;
        }

        return 0;
    }

    private int getFirstK(int[] array, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (array[middle] == k) {
            if ((middle > 0 && array[middle - 1] != k) || middle == 0) {
                return middle;
            } else {
                end = middle - 1;
            }
        } else if (array[middle] < k) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }

        return getFirstK(array, k, start, end);
    }

    private int getLastK(int[] array, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        if (array[middle] == k) {
            if ((middle <array.length-1&& array[middle + 1] != k) || middle == array.length-1) {
                return middle;
            } else {
                start = middle + 1;
            }
        } else if (array[middle] < k) {
            start = middle + 1;
        } else {
            end = middle - 1;
        }

        return getLastK(array, k, start, end);
    }

}
