package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/12/6
 * @des 数组中只出现一次的数字
 */
public class Solution40 {

    public static void main(String[] args) throws Exception {

        int[] array = new int[]{1,2,2,3,3,4,5,7,3,5,3,4,1};
        System.out.println("数组中只出现一次的数字：" + NumberOfApperanceOneA(array));

    }

    //数组中只有一个数字出现了一次
    private static int NumberOfApperanceOneA(int[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("array==null||array.length==0");
        }
        int result=0;
        for(int i=0;i<array.length;i++) {
            result = array[i] ^ result;
        }
        return result;
    }

    //数组中有两个数字出现了一次 时间复杂度O(n)，空间复杂度O(1)
    private static void NumberOfApperanceOneB(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = array[i] ^ result;
        }
        int index = findTheFirstBitIsOne(result);

        for (int i = 0; i < array.length; i++) {
            if (someBitIsOne(array[i],index)) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }

    private static int findTheFirstBitIsOne(int result) {

        int flag=1;

        int index=1;

        while ((result & flag)== 0) {
            flag = 1 << index++;
        }
        return index;
    }

    private static boolean someBitIsOne(int number, int index) {
        return (number & (1<<(index-1)))!=0;
    }

}
