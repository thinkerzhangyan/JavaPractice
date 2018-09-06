package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 把数组排成最小的数
 */
public class Solution32 {

    public static void main(String[] args) {
        int[] target = new int[]{3,32,321};
        System.out.println(printMinNumberA(target));
    }

    //求出所有的排列组合然后求出最小的值  O(N*N)
    public static String printMinNumberA(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return "";
        }

        List<String> list = new ArrayList<>();

        permutation(numbers, 0, list);

        Collections.sort(list);

        return list.get(0);

    }


    private static void permutation(int[] array, int index, List<String> list) {

        if (index == array.length) {
            if (!list.contains(String.valueOf(array))) {
                String str = "";
                for (int i = 0; i < array.length; i++) {
                    str += array[i];
                }
                list.add(str);
            }
        } else {
            for (int i=index;i<array.length;i++) {
                swap(array, i, index);
                permutation(array, index + 1, list);
                swap(array, i, index);
            }
        }

    }

    private static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    //根据规则，将item排列，最后组合就好。O(NlogN)。
    public String printMinNumberB(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return "";
        }

        ArrayList<Integer> list = new ArrayList<>();

        int len = numbers.length;

        for(int i=0;i<len;i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });


        String s = "";

        for (int j : list) {
            s+= j;
        }

        return s.trim();

    }

}
