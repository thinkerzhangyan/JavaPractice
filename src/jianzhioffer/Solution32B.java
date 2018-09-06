package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution32B {

    public static void main(String[] args) {
        System.out.println(printMinNumberA(new int[]{1, 2, 3}));

    }

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

    public static String printMinNumberB(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return "";
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i] + "");
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });

        String result = "";
        for (String str : list) {
            result += str;
        }
        return result.trim().toString();
    }
}
