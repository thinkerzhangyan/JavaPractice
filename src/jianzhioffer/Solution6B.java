package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/11/16
 * @des
 */
public class Solution6B {

    public static void main(String[] args) {

    }

    public int minNumberInRotareArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int head = 0;
        int tail = array.length - 1;

        int mid = head;

        while (array[head] >= array[tail]) {
            if (tail - head == 1) {
                return array[tail];
            }
            mid = head + (tail - head) / 2;
            if (array[head] == array[mid] && array[tail] == array[mid]) {
                return minInArray(array, head, tail);
            }
            if (array[mid] >= array[head]) {
                head = mid;
            } else if (array[mid] <= array[tail]) {
                tail = mid;
            }
        }

        return array[mid];
    }

    private int minInArray(int[] array, int head, int tail) {
        int min = array[head];
        for (int index = head+1;index<=tail;index++) {
            if (array[index] < min) {
                min = array[index];
            }
        }
        return min;
    }

}
