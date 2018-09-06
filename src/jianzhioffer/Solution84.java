package jianzhioffer;

import java.util.HashMap;

/**
 * @author zhangyan
 * @date 2018/8/30
 * @des 一个数组，[1,2,9,3,2,8]只有一个重复数，找出这个重复数，考虑时间复杂度。
 */
public class Solution84 {

    //先排序，然后查找，时间复杂度O(NlogN)，空间O(1)
    public int duplicateA(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }


        return -1;

    }

    //利用Hash，时间复杂度O(N),空间复杂度O(N)
    public int duplicateB(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i=0;i<numbers.length;i++) {
            if (hashMap.containsKey(numbers[i])) {
                return numbers[i];
            } else {
                hashMap.put(numbers[i], 1);
            }
        }

        return -1;
    }


    //利用BitMap，时间复杂度O(NlogN)，空间O....
    public int duplicateC(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        BitMap bitMap = new BitMap(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            if (bitMap.contain(numbers[i])) {
                return numbers[i];
            } else {
                bitMap.add(numbers[i]);
            }
        }

        return -1;

    }

    //利用BitMap，时间复杂度O(NlogN)，空间O....
    public int duplicateD(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        int result = 1;

        for (int i = 0; i < numbers.length; i++) {
            result ^= numbers[i];
            if (result == 0) {
                return numbers[i];
            }
        }

        return -1;

    }


    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 5, 5};

        Solution84 solution82 = new Solution84();

        System.out.println(solution82.duplicateA(numbers));
        System.out.println(solution82.duplicateB(numbers));
        System.out.println(solution82.duplicateC(numbers));
        System.out.println(solution82.duplicateD(numbers));

    }
}
