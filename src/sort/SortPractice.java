package sort;


import java.util.Arrays;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class SortPractice {


    public static void sort(Integer[] a) {

        int[] helpArray = new int[65536];

        for (int i = 0; i < a.length; i++) {
            helpArray[a[i]]++;
        }

        int k = 0;

        for (int i = 0; i < helpArray.length; i++) {
            if (helpArray[i] > 0) {
                for (int j = 0; j < helpArray[i]; j++) {
                    a[k++] = i;
                }
            }
        }
    }


    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int a, int b) {
        return a < b;
    }


    public static void main(String[] args) {

        Integer[] array = new Integer[]{2, 4, 1, 2, 777, 33, 22, 11, 1, 5, 4, 3, 1, 8, 9, 444, 233, 85, 22, 4, 2, 4, 5, 8, 4, 7, 6};

        SortPractice.sort(array);

        //Bubble.sort(array);

        System.out.println(Arrays.asList(array));


    }


}
