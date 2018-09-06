package jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/8/19
 * @des 子数组只和
 *
 * 求数组中若干个元素之和等于给定值
 *
 * 参考链接：
 *         https://www.jianshu.com/p/b3e22a80dbd6
 *         https://blog.csdn.net/ljlstart/article/details/48393675
 *         https://www.cnblogs.com/theskulls/p/4872718.html
 *
 */
public class Solution81 {


    //第一种思路：利用两个for循环，每次取出一个元素依次与后面的元素相加，时间复杂度是O(n^2)。
    public static ArrayList<Integer> subarraySumA(int[] nums,int target) {

        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        int len = nums.length;

        int sum = 0;

        for (int i = 0; i < len; i++) {
            for (int j=i;j<len;j++) {
                sum += nums[j];
                if (sum == target) {
                    list.add(i);
                    list.add(j);
                }
            }
            sum = 0;
        }

        return list;
    }


    //第二种思路：利用一个map记录从第一个元素开始到当前元素之和以及当前元素的下标，
    //如果后面的连续元素之和为零那么sum不变，此时就找到了和为零的连续序列，时间复杂度是O(n)
    public static ArrayList<Integer> subarraySumB(int[] nums,int target) {

        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,target);// 第一个元素为 0 id 应该为-1

        int len = nums.length;

        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                list.add(map.get(sum) + 1);
                list.add(i);
                return list;
            }

            map.put(sum, i);
        }

        return list;
    }


    public static void main(String[] args) {

        int[] array = new int[]{-3, 1, 2, -3, 4};

        List<Integer> listA = subarraySumA(array,3);

        if (listA.size() == 2) {
            int headIndex = listA.get(0);
            int tailIndex = listA.get(1);
            System.out.println(headIndex + ":" + tailIndex);
        }


        List<Integer> listB = subarraySumB(array,3);

        if (listB.size() != 0) {
            int headIndex = listB.get(0);
            int tailIndex = listB.get(1);
            System.out.println(headIndex + ":" + tailIndex);
        }
    }
}
