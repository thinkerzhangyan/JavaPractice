package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangyan
 * @date 2018/1/17
 * @des 最小的k个数
 */
public class Solution29 {

    public static void main(String[] args) {
        int[] target = new int[]{4,5,1,6,2,7,3,8};
        System.out.println(getTheKLeastNumbersB(target,4));
    }

    public static ArrayList<Integer> getTheKLeastNumbersA(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return list;
        }

        if (input.length == k) {
            for(int i=0;i<input.length;i++) {
                list.add(input[i]);
            }
            return list;
        }

        int lo = 0;
        int hi = input.length - 1;

        int index = partition(input, lo, hi);

        while ((k - 1) != index) {
            if (index > k-1) {
                hi = index - 1;
                index = partition(input, lo, hi);
            } else {
                lo = index + 1;
                index = partition(input, lo, hi);
            }
        }

        for(int i=0;i<k;i++) {
            list.add(input[i]);
        }

        return list;

    }

    //参考连接：https://ych0112xzz.github.io/2016/10/27/PriorityQueue/
    public static ArrayList<Integer> getTheKLeastNumbersB(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return list;
        }

        //构建一个最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        queue.add(input[0]);

        for(int i=1;i<input.length;i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else {
                if (queue.peek() > input[i]) {
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }

        for (Integer val : queue) {
            list.add(val);
        }
        return list;

    }


    private static int  partition(int[] input, int lo, int hi) {

        int i = lo, j = hi + 1;

        int v = input[lo];

        while (true) {

            while(less(input[++i],v)) if(i==hi) break;
            while (less(v,input[--j])) if(j==lo) break;

            if (i >= j) break;

            exch(input, i, j);
        }

        exch(input, lo, j);

        return j;
    }

    private static void exch(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }

}
