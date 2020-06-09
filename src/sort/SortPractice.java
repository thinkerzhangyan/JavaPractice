package sort;


import java.util.Arrays;
import java.util.NavigableMap;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class SortPractice {

    public static void sort(Integer[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int N = a.length;
        for (int k=N/2;k>0;k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j<N&&less(a,j,j+1)) j++;
            if (less(a,j,k)) break;
            exch(a, j, k);
            k = j;
        }
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable v = a[i-1];
        a[i-1] = a[j-1];
        a[j - 1] = v;
    }

    private static boolean less(Comparable[] a,int i,int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }


    public static void main(String[] args) {

        Integer[] array = new Integer[]{2, 4, 1, 2, 777, 33, 22, 11, 1, 5, 4, 3, 1, 8, 9, 444, 233, 85, 22, 4, 2, 4, 5, 8, 4, 7, 6};

        SortPractice.sort(array);

        //Bubble.sort(array);

        System.out.println(Arrays.asList(array));


    }


}
