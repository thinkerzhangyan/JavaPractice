package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution13B {


    public static void main(String[] args) {

//        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        reOrderA(array, new MyStandardInterface());
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//
//        System.out.println(" ");
//
//        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        reOrderB(array, new MyStandardInterface());
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        reOrderArrayA(array, new StandardInterface() {
            @Override
            public boolean isStandard(int val) {
                return val % 2 == 1;
            }
        });

        for (int i=0;i<array.length;i++) {
            System.out.print(array[i] + (i != array.length - 1 ? "," : ""));
        }
        System.out.println("");


        int[] arrayB = new int[]{1, 2, 3, 4, 5, 6, 7};

        reOrderArrayB(arrayB, new StandardInterface() {
            @Override
            public boolean isStandard(int val) {
                return val % 2 == 1;
            }
        });

        for (int i=0;i<arrayB.length;i++) {
            System.out.print(arrayB[i] + (i != arrayB.length - 1 ? "," : ""));
        }


    }


    public interface StandardInterface{
        boolean isStandard(int val);
    }

    public static void reOrderArrayA(int[] array, StandardInterface standardInterface) {
        if (array == null || array.length == 0 || standardInterface == null) {
            return;
        }
        int N = array.length;
        for (int i=1;i<N;i++) {
            for (int j=i;j>0&&standardInterface.isStandard(array[j])&&!standardInterface.isStandard(array[j-1]);j--) {
                exch(array, j, j - 1);
            }
        }
    }

    public static void reOrderArrayB(int[] array, StandardInterface standardInterface) {
        if (array == null || array.length == 0 || standardInterface == null) {
            return;
        }
        int head = 0;
        int tail = array.length - 1;
        while (head < tail) {
            while (standardInterface.isStandard(array[head]) && head < tail) {
                head++;
            }
            while (!standardInterface.isStandard(array[tail]) && head < tail) {
                tail--;
            }
            if (head < tail) {
                exch(array, head, tail);
            }
        }
    }

    private static void exch(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

