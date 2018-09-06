package sort;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class Merge {

    private static Comparable[] aux ;

    //归并排序利用了归并的思想，先（递归的）将数组分成两半进行排序，然后将结果归并起来。
    //归并排序，任意长度为N的数组，排序所需的时间为NlogN。
    //平均O(NlogN)，最坏O(NlogN)，最好O(NlogN)，空间O(N),稳定。
    public static void sort(Comparable[] a){

        aux = new Comparable[a.length];
        sort(a,0,a.length-1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if(hi<=lo)
            return;

        int mid = lo+(hi-lo)/2;

        sort(a,lo,mid);
        sort(a,mid+1,hi);

        merge(a,lo,mid,hi);


    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i=lo,j=mid+1;

        for(int k=lo;k<=hi;k++)
            aux[k]=a[k];

        for(int k=lo;k<=hi;k++){

            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];

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
