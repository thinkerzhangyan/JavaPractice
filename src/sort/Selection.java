package sort;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class Selection {

    //选择排序，运行时间和输入无关，数据移动最少。
    //平均 O(N*N)，最坏O(N*N)，最好O(N*N),空间O(1)  不稳定
    public static void sort(Comparable[] a){

        int N = a.length;

        for(int i=0;i<N;i++){

            int min = i;

            for(int j=i+1;j<N;j++){
                if(less(a[j],a[min])) min = j;
            }

            exch(a,i,min);
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
