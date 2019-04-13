package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution13B {


    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        reOrderA(array, new MyStandardInterface());

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(" ");

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        reOrderB(array, new MyStandardInterface());

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }


    }

    //数组中奇数位于偶数的前面，相对顺序可以改变。
    public static void reOrderA(int[] array, StandardInterface standardInterface) {

        if (array == null || array.length == 0) {
            return;
        }

        int head = 0;
        int tail = array.length - 1;


        while (head < tail) {

            while (head < tail && !standardInterface.isStandard(array[head])) {
                head++;
            }

            while (head < tail && standardInterface.isStandard(array[tail])) {
                tail--;
            }

            if (head < tail) {
                exch(array, head, tail);
            }

        }

    }

    //数组中奇数位于偶数的前面，相对顺序不可以改变，利用了插入排序的思想。
    public static void reOrderB(int[] array, StandardInterface standardInterface) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && standardInterface.isStandard(array[j - 1]) && !standardInterface.isStandard(array[j]); j--) {
                exch(array, j, j - 1);
            }
        }

    }

    public interface StandardInterface {
        boolean isStandard(int val);
    }

    public static class MyStandardInterface implements StandardInterface {

        @Override
        public boolean isStandard(int val) {
            return (val & 0x01) == 0;
        }
    }

    private static void exch(int[] array, int head, int tail) {
        int tmp = array[head];
        array[head] = array[tail];
        array[tail] = tmp;
    }


}

