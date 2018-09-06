package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 数组中出现次数超过一半的数字
 */
public class Solution28 {

    public static void main(String[] args) throws Exception {
        System.out.println(resolveA(new int[]{4, 2, 1, 4, 2, 4}));
    }

    //思路一，先进行排序，然后再统计。

    //思路二，利用partation函数。  该思想同样适用与求数组中，任意第K大的数字。时间复杂度为O(N)
    public static int resolveA(int[] array) throws Exception {

        if (array == null || array.length == 0) {
            throw new Exception("array == null || array.length == 0");
        }


        int middle = array.length >> 1;

        int lo = 0;
        int hi = array.length - 1;

        if (lo == hi) {
            return array[0];
        }

        int index = partation(array, lo, hi);

        while (middle != index) {

            if (index < middle) {
                lo = index + 1;
            } else {
                hi = index - 1;
            }
            index = partation(array, lo, hi);

        }

        if (!checkIsStandardInput(array, array[middle])) {
            return 0;
        }

        return array[middle];
    }

    //思路三
    public static int resovleB(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }


        int result = array[0];
        int times = 1;

        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (result == array[i]) {
                times++;
            } else if (result != array[i]) {
                times--;
            }
        }

        if (!checkIsStandardInput(array, result)) {
            return 0;
        }

        return result;
    }

    private static boolean checkIsStandardInput(int[] array, int result) {
        int apperanceTimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i]) {
                apperanceTimes++;
            }
        }
        if (apperanceTimes * 2 <= array.length) {
            return false;
        } else {
            return true;
        }
    }

    private static int partation(int[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        int v = a[lo];

        while (true) {

            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;

            if (i >= j) break;

            exch(a, i, j);
        }

        exch(a, lo, j);

        return j;

    }


    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exch(int[] a, int i, int j) {

        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }
}
