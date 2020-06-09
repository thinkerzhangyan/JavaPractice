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

        int head = 0;
        int tail = array.length - 1;

        if (head == tail) {
            return array[0];
        }

        int mid = head + (tail - head) / 2;

        int j = partition(array, head, tail);

        while (j != mid) {
            if (j < mid) {
                head = j + 1;
            } else if (j > mid) {
                tail = j - 1;
            }
            j = partition(array, head, tail);
        }

        if (!checkInStandrdInput(array, array[j])) {
            return 0;
        }

        return array[mid];
    }

    private static int partition(int[] array, int lo, int hi) {
        int i = lo, j = hi + 1;
        Integer v = array[lo];
        while (true) {
            while (less(array[++i], v)) if (i == hi) break;
            while (less(v, array[--j])) if (j==lo) break;
            if (i >= j) {
                break;
            }
            exch(array, i, j);
        }
        exch(array, lo, j);
        return j;
    }

    private static boolean less(Integer a, Integer b) {
        return a < b;
    }

    private static void exch(int[] array, int i, int j) {
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static boolean checkInStandrdInput(int[] array, int target) {
        if (array == null || array.length == 0 ) {
            return false;
        }

        int count = 0;

        for (int index=0;index<array.length;index++) {
            if (array[index] == target) {
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
        int times = 0;
        int target = array[0];


        for (int index=1;index<array.length;index++) {
            if (target == array[index]) {
                times++;
            } else if (times == 0) {
                target = array[index];
                times = 1;
            } else {
                times--;
            }
        }

        if (!checkInStandrdInput(array, target)) {
            return 0;
        }

        return target;
    }
}
