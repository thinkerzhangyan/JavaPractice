package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des
 */
public class Solution29B {

    public static void main(String[] args) {
        int[] target = new int[]{4,5,1,6,2,7,3,8};
        System.out.println(findKthLeastNumberA(target,4));
    }

    public static ArrayList<Integer> findKthLeastNumberA(int[] array, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return list;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });//构建一个最大堆


        for (int i = 0; i < array.length; i++) {
            if (queue.size() < k) {
                queue.add(array[i]);
            } else {
                if (queue.peek() > array[i]) {
                    queue.poll();
                    queue.add(array[i]);
                }
            }
        }

        for (Integer val : queue) {
            list.add(val);
        }

        return list;
    }


    public ArrayList<Integer> findKthLeastNumberB(int[] array, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length == 0 || k <= 0 || k > array.length) {
            return list;
        }

        int lo =0;
        int hi = array.length - 1;

        if (array.length == k) {
            for(int i=0;i<array.length;i++) {
                list.add(array[i]);
            }
            return list;
        }

        int index = partition(array, lo, hi);

        while ((k - 1) != index) {
            if ((k - 1) > index) {
                lo = index + 1;
                index = partition(array, lo, hi);
            } else {
                hi = index - 1;
                index = partition(array, lo, hi);
            }
        }

        for(int i=0;i<k;i++) {
            list.add(array[i]);
        }

        return list;
    }



    private int partition(int[] array, int lo, int hi) {

        int i = lo, j = hi + 1;

        int v = array[lo];


        while (true) {

            while (less(array[++i],v)) if(i==hi) break;
            while (less(v,array[--j])) if(j==lo) break;

            if(i>=j) break;

            exch(array, i, j);
        }

        exch(array, lo, j);

        return j;
    }

    private void exch(int[] array, int lo, int j) {
        int tmp = array[lo];
        array[lo] = array[j];
        array[j] = tmp;
    }

    private boolean less(int i, int v) {
        return i < v;
    }
}
