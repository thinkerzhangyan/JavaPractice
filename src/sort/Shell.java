package sort;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class Shell {

    //希尔排序是对插入排序的改进，插入排序对于乱序数组性能比较差，例如最小的元素位于数组的最右端的情况，而希尔排序是先构建h有序数组，实现部分有序，
    //然后最后通过插入排序来实现整个数组的排列。注意构建的递增序列都必须以1结尾。
    //算法的性能不仅取决于h，还取决于h之间的数学性质，比如他们之间的公因子等。
    //在该希尔算法的实现中选择的递增序列的性能和其他复杂递增序列的性能是相近的，但是复杂序列在最坏情况的下的性能优于我们所使用的序列。
    //相比较于选择排序和插入排序，希尔排序也可以应用于大规模的数组，他对于任意排序的数组表现也足够良好。
    //有经验的程序员有时会选择使用希尔排序，因为对于中小规模的数组，希尔排序的性能是可以接受的，而且代码辆比较少，不需要额外的存储空间。其他更高级的算法可能只会比希尔排序
    //快两倍（可能还达不到），而且更复杂。
    //平均O(N1.3次幂)，最坏O(N*N),最好O(N),空间O(1),不稳定。
    public static void sort(Comparable[] a) {

        int N = a.length;
        int h = 1;

        while (h < N / 3) h = h * 3 + 1;

        while (h >= 1) {

            for (int i = h; i < N; i++) {

                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }

            }
            h = h / 3;
        }

    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {

        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

}
