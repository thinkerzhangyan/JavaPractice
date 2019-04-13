package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 旋转数组的最小的数字
 */
public class Solution6 {

    public int minNumberInRotateArray(int[] array) throws Exception {

        if (array == null || array.length == 0) {
            throw new Exception("数组有误");
        }

        int head = 0;
        int tail = array.length - 1;

        int mid = head;

        while (array[head] >= array[tail]) {

            if (tail - head == 1) {
                return array[tail];
            }

            mid = head + (tail - head) / 2;

            if (array[mid] == array[head] && array[mid] == array[tail]) {
                return minInOrder(array, head, tail);
            }

            if (array[mid] >=array[head]) {
                head = mid;
            } else if (array[mid] <= array[tail]) {
                tail = mid;
            }

        }

        return array[mid];
    }

    private int minInOrder(int[] array, int head, int tail) {

        int min = array[head];

        for(int i=head+1;i<=tail;i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;

    }


}

