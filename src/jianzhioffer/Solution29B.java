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
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
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
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }


    public int[] findKthLeastNumberB(int[] array, int k) {

        int[] list = new int[k];

        if (array == null || array.length == 0 || k > array.length || k <= 0) {
            return list;
        }

        if (k == array.length) {
            for (int i=0;i<array.length;i++) {
                list[i] = array[i];
            }
            return list;
        }

        int head = 0;
        int tail = array.length - 1;

        int j = partition(array, head, tail);

        while (j != k - 1) {
            if (j < k - 1) {
                head = j + 1;
            } else {
                tail = j - 1;
            }
            j = partition(array, head, tail);
        }

        for (int i=0;i<k;i++) {
            list[i]=array[i];
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
