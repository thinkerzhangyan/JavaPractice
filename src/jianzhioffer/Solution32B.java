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
        System.out.println(printMinNumberB(new int[]{1, 2, 3}));


        System.out.println(printMinNumberA(new int[]{3, 32, 321}));
        System.out.println(printMinNumberB(new int[]{3, 32, 321}));

    }


    public static String printMinNumberA(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return "";
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i] + "".trim());
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

        return result;

    }

    public static String printMinNumberB(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return "";
        }


        List<String> list = new ArrayList<>();

        permutation(numbers, 0, list);

        Collections.sort(list);

        return list.get(0);

    }

    private static void permutation(int[] numbers, int index, List<String> list) {

        if (index == numbers.length) {

            String result = "";

            for (Integer integer : numbers) {
                result = result + integer + "";
            }

            if (!list.add(result)) {
                list.add(result);
            }

        } else {
            for (int i = index; i < numbers.length; i++) {
                swap(numbers, i, index);
                permutation(numbers, index + 1, list);
                swap(numbers, i, index);
            }
        }

    }


    private static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

}
