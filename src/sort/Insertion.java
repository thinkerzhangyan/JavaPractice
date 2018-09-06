package sort;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class Insertion {

    //插入排序所需要的时间取决于输入的元素的初始的顺序。
    //平均 1／4 N*N 比较 1／4 N*N交换，最坏 1／2 N*N 比较 1／2N*N 交换，最好 N-1比较 0交换。
    //插入排序比较适用于部分有序的数组。
    // 平均 O(N*N)，最坏O(N*N)，最好O(N),空间O(1)  稳定
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {

            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }

        }

    }

    private static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    private static void exch(Comparable[] a,int i,int j){

        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;

    }

}
