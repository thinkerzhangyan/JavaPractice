package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/12/6
 * @des 调整数组的顺序，使得奇数位于偶数的前面（分两种情况，相对顺序是否可变）
 */
public class Solution13 {


    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        reOrderArrayA(array, new MyInterface() {
            @Override
            public boolean standard(int number) {
                return (number & 0x01) != 0;
            }
        });

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(" ");

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        reOrderArrayBA(array, new MyInterface() {
            @Override
            public boolean standard(int number) {
                return (number & 0x01) != 0;
            }
        });

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }




    }

    //奇数和奇数，偶数和偶数的相对顺序可以改变
    public static void reOrderArrayA(int[] array, MyInterface myInterface) {

        if (array == null || array.length == 0) {
            return;
        }

        int headIndex = 0;
        int tailIndex = array.length - 1;

        while (headIndex < tailIndex) {

            while ((headIndex < tailIndex) && myInterface.standard(array[headIndex])) {
                headIndex++;
            }

            while ((headIndex < tailIndex) && !myInterface.standard(array[tailIndex])) {
                tailIndex--;
            }

            if (headIndex < tailIndex) {
                swap(array, headIndex, tailIndex);
            }

        }

    }


    public interface MyInterface {
        boolean standard(int number);
    }

    private static void swap(int[] array, int head, int tail) {
        int tmp = array[head];
        array[head] = array[tail];
        array[tail] = tmp;
    }


    //奇数和奇数，偶数和偶数的相对顺序不可以改变,利用了插入排序的思想。
    public static void reOrderArrayBA(int[] array, MyInterface myInterface) {

        if (array == null || array.length == 0) {
            return;
        }

        int N = array.length;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && ((!myInterface.standard(array[j])) && (myInterface.standard(array[j - 1]))); j--) {
                swap(array, j, j - 1);
            }
        }

    }


}
