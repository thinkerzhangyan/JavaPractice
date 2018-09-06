package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des
 */
public class Solution28B {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(findNumerMoreThanHalfA(array));
    }

    public static int findNumerMoreThanHalfA(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int middle = array.length >> 1;

        int lo = 0;
        int hi = array.length - 1;

        if (lo == hi) {
            return array[0];
        }

        int index = partition(array, lo, hi);

        while (middle != index) {

            if (index < middle) {
                lo = index + 1;
                index = partition(array, lo, hi);
            } else {
                hi = index - 1;
                index= partition(array, lo, hi);
            }

        }

        if (!checkInStandrdInput(array, array[middle])) {
            return 0;
        }

        return array[middle];

    }

    private static int partition(int[] array, int lo, int hi) {

        int i = lo, j = hi + 1;
        int v = array[lo];

        while (true) {
            while (less(array[++i], v)) if (i == hi) break;
            while (less(v, array[--j])) if (j == lo) break;
            if (i >= j) {
                break;
            }
            exch(array, i, j);
        }
        exch(array, lo, j);
        return j;
    }

    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exch(int[] array, int i, int j) {
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static boolean checkInStandrdInput(int[] array, int result) {
        if (array == null || array.length == 0) {
            return false;
        }

        int count = 0;

        for (int i=0;i<array.length;i++) {
            if (array[i] == result) {
                count++;
            }
        }

        if (count * 2 <= array.length) {
            return false;
        } else {
            return true;
        }
    }


    public static int findNumerMoreThanHalfB(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int result = array[0];
        int times = 1;

        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times++;
            } else if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }

        if (!checkInStandrdInput(array, result)) {
            return 0;
        }

        return result;

    }
}
