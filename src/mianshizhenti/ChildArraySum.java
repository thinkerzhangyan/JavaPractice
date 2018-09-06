package mianshizhenti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/8/18
 * @des 子数组之和，给出一个数组array和数字sum，输出数组array中的和为sum的子数组。
 */
public class ChildArraySum {

    public static void main(String[] args) {

        int[] array = new int[]{3, 4, 2, 6, 1, 5};

        List<Integer> list = subarraySumA(array, 10);

        if (list.size() == 2) {
            int headIndex = list.get(0);
            int tailIndex = list.get(1);

            for (int i = headIndex; i <= tailIndex; i++) {
                System.out.println(array[i]);
            }
        }

    }

    //只输出一个子数组
    public static ArrayList<Integer> subarraySumA(int[] nums, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        sort(nums);

        Stack<Integer> stack = new Stack<>();

        int sum = 0;

        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            stack.push(nums[i]);
        }



        return list;
    }


    //只输出一个子数组
    public static ArrayList<Integer> subarraySumB(int[] nums, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int len = nums.length;

        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                list.add(map.get(sum - k) + 1);
                list.add(i);
                return list;
            }

            map.put(sum, i);
        }

        return list;
    }

    //平均O(NlogN)，最坏O(N*N),最好O(NlogN),空间O(NlogN),不稳定
    public static void sort(int[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {

        if(hi<=lo)
            return;

        int j = partition(a,lo,hi);

        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(int[] a, int lo, int hi) {

        int i = lo,j=hi+1;

        int v = a[lo];

        while(true){

            while(less(a[++i],v)) if(i==hi) break;
            while(less(v,a[--j])) if(j==lo) break;

            if(i>=j) break;

            exch(a,i,j);
        }

        exch(a,lo,j);

        return j;

    }


    private static boolean less(int a,int b){
        return a<=0;
    }

    private static void exch(int[] a,int i,int j){

        int t = a[i];
        a[i]=a[j];
        a[j]=t;

    }

}
