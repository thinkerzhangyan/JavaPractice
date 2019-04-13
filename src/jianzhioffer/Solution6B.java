package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/11/16
 * @des
 */
public class Solution6B {

    public static void main(String[] args) {

    }

    private int findMinNumberInRotateArray(int[] array) throws Exception {

        if (array == null || array.length == 0) {
            return -1;
        }

        int head = 0;
        int tail = array.length - 1;

        int mid = head;

        while (array[head] >= array[tail]) {

            if (tail - head == 1) {
                return array[tail];
            }

            mid = head + (tail - head) / 2;

            if ((array[mid] == array[head]) && (array[mid] == array[tail])) {
                return findMinNumber(array, head, tail);
            }

            if (array[mid] >= array[head]) {
                head = mid;
            } else if (array[mid] <= array[tail]) {
                tail = mid;
            }

        }

        return array[mid];
    }

    private int findMinNumber(int[] array, int head, int tail) {

        int min = array[head];

        for (int i = head + 1; i <= tail; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;

    }


}
