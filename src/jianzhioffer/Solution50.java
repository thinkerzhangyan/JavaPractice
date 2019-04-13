package jianzhioffer;

import java.util.HashMap;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 */
public class Solution50 {

    //1 O(N*N) 两层遍历

    //2 排序 O(nlogn)

    public boolean duplicateA(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return false;
            }
        }

        sort(numbers);

        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (result == numbers[i]) {
                duplication[0] = result;
                return true;
            } else {
                result = numbers[i];
            }
        }

        return false;
    }

    //3 利用哈希表 O(n) O(n)

    public boolean duplicateB(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return false;
            }
        }

        HashMap<Integer, Integer> hashMap = new HashMap(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                hashMap.put(numbers[i], 1);
            }
        }

        return false;
    }


    //4 利用BitMap算法

    public boolean duplicateC(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }


        BitMap bitMap = new BitMap(numbers.length - 1);


        for (int i = 0; i < numbers.length; i++) {

            if (bitMap.contain(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                bitMap.add(numbers[i]);
            }

        }

        return false;
    }


    //5 https://blog.csdn.net/jsqfengbao/article/details/47438557

    public boolean duplicateD(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return false;
            }
        }

        for (int i = 0; i < numbers.length; i++) {

            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = tmp;
            }

        }

        return false;
    }


    // 6
    //
    // O(logN)  O(1)
    //
    // 思路
    //
    // https://www.jianshu.com/p/f0bec6ae99ee?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
    // http://www.cnblogs.com/grandyang/p/4843654.html
    //
    // 在区间[0, n-1]中搜索，首先求出中点mid，然后遍历整个数组，统计所有小于等于mid的数的个数，
    // 如果个数大于mid，则说明重复值在[0, mid]之间，反之，重复值应在[mid+1, n]之间，
    // 然后依次类推，直到搜索完成，此时的low就是我们要求的重复值，参见代码如下：
    //
    public int duplicateE(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (Integer a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;

        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        int v = a[lo];

        while (true) {

            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;

            if (i >= j) break;

            exch(a, i, j);
        }

        exch(a, lo, j);

        return j;

    }


    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exch(int[] a, int i, int j) {

        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }


    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 5, 5};

        Solution50 solution82 = new Solution50();


        int[] resultA = new int[1];
        int[] resultB = new int[1];
        int[] resultC = new int[1];
        int[] resultD = new int[1];


        System.out.println(solution82.duplicateA(numbers, numbers.length, resultA) + ":" + resultA[0]);

        System.out.println(solution82.duplicateB(numbers, numbers.length, resultB) + ":" + resultB[0]);

        System.out.println(solution82.duplicateC(numbers, numbers.length, resultC) + ":" + resultC[0]);

        System.out.println(solution82.duplicateD(numbers, numbers.length, resultD) + ":" + resultD[0]);

        System.out.println(solution82.duplicateE(numbers));




    }

}
