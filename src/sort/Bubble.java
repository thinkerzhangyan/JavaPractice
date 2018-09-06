package sort;

import java.util.Arrays;

/**
 * Created by hzzhangyan3 on 2016/8/29.
 */
public class Bubble {

    //冒泡排序算法的流程如下：
    //比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    //对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
    //针对所有的元素重复以上的步骤，除了最后一个。
    //持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
    //算法复杂度都是 O(n^2)，空间复杂度是常数 O(1)
    //平均O(N*N)，最坏O(N*N),最好O(N) 空间O(1) 稳定
    //关于最好情况下的时间复杂度，建议阅读：https://www.cnblogs.com/melon-h/archive/2012/09/20/2694941.html
    public static void sort(Comparable[] a){

        int N = a.length;

        boolean isSorted = true;

        for(int i=0;i<N;i++){

            for(int j=1;j<N-i;j++){

                if(!less(a[j-1],a[j])){

                    Comparable tmp = a[j-1];
                    a[j-1]=a[j];
                    a[j]=tmp;

                    isSorted = false;

                }

            }

            if (isSorted) {
                return;
            }

        }

    }


    private static void exch(Comparable[] a,int i,int j){

        Comparable v = a[i];
        a[i]=a[j];
        a[j]=v;

    }


    private static boolean less(Comparable a,Comparable b){

        return a.compareTo(b)<0;

    }


    public static void main(String[] args) {

        Integer[] array = new Integer[]{2, 4, 1, 2, 777, 33, 22, 11, 1, 5, 4, 3, 1, 8, 9, 444, 233, 85, 22, 4, 2, 4, 5, 8, 4, 7, 6};

        SortPractice.sort(array);

        //Bubble.sort(array);

        System.out.println(Arrays.asList(array));


    }

}
