package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution40B {

    public static void main(String[] args) throws Exception {
        int[] array = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] result = findTwoNumberApperanceOne(array);
        for (int i=0;i<2;i++) {
            System.out.println(result[i]);
        }
    }

    private int findOneNumberApperanceOne(int[] array) throws Exception {

        if (array == null || array.length == 0) {
            return -1;
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = array[i] ^ result;
        }
        return result;

    }


    private static int[] findTwoNumberApperanceOne(int[] array) throws Exception {

        if (array == null || array.length == 0) {
            return null;
        }

        int target = 0;
        for (int i = 0; i < array.length; i++) {
            target = array[i] ^ target;
        }

        int bits = getFirstBitNotOne(target);

        int flags = 1 << (bits - 1);

        int[] result = new int[2];

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flags) != 0) {
                result[0] = result[0] ^ array[i];
            } else {
                result[1] = result[1] ^ array[i];
            }
        }

        return result;
    }

    private static int getFirstBitNotOne(int target) {

        int count = 1;

        int flag = 1;

        while ((target & flag) == 0) {
            flag = flag << 1;
            count++;
        }
        return count;
    }


}
