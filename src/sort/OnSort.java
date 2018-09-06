package sort;

import java.util.Arrays;

/**
 * @author zhangyan
 * @date 2018/7/31
 * @des
 */
public class OnSort {

    // 时间复杂度为O(N)的排序算法
    // 参考链接
    // https://blog.csdn.net/liuyukuan/article/details/53792021
    // https://blog.csdn.net/djb100316878/article/details/42100053
    // http://zhedahht.blog.163.com/blog/static/25411174201131184017844/
    public static void sort(int[] a) {

        if (a == null || a.length == 0) {
            return;
        }

        int N = 65536;

        int[] newArray = new int[N];

        int length = a.length;

        for (int i=0;i<length;i++) {
            newArray[a[i]]++;
        }

        int index = 0;

        for (int i=0;i<N;i++) {
            for (int j=0;j<newArray[i];j++) {
                a[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {

        Integer[] array = new Integer[]{2, 4, 1, 2, 777, 33, 22, 11, 1, 5, 4, 3, 1, 8, 9, 444, 233, 85, 22, 4, 2, 4, 5, 8, 4, 7, 6};

        SortPractice.sort(array);

        //Bubble.sort(array);

        System.out.println(Arrays.asList(array));


    }

}

