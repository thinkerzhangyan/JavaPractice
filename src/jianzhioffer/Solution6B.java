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

        int headIndex = 0;
        int tailIndex = array.length - 1;

        int mid = headIndex;

        while (array[headIndex] >= array[tailIndex]) {

            if (tailIndex - headIndex == 1) {
                return array[tailIndex];
            }

            mid = headIndex + (tailIndex - headIndex) / 2;

            if (array[headIndex] == array[mid] && array[tailIndex] == array[mid]) {
                return findMinNumberInRotateArray(array, headIndex, tailIndex);
            }
            if (array[mid] >= array[headIndex]) {
                headIndex = mid;
            } else if (array[mid] <= array[tailIndex]) {
                tailIndex = mid;
            }
        }


        return array[mid];
    }


    private int findMinNumberInRotateArray(int[] array, int head, int tail) {

        int min = array[head];

        for (int index=head+1;index<=tail;index++) {
            if (array[index] < min) {
                min = array[index];
            }
        }

        return min;
    }

}
