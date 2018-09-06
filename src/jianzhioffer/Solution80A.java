package jianzhioffer;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/8/19
 * @des 子数组之和
 * <p>
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 样例给出[-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
 * <p>
 * 参考链接：
 * https://www.jianshu.com/p/b3e22a80dbd6
 * https://blog.csdn.net/ljlstart/article/details/48393675
 * https://www.cnblogs.com/theskulls/p/4872718.html
 */
public class Solution80A {


    //第一种思路：利用两个for循环，每次取出一个元素依次与后面的元素相加，时间复杂度是O(n^2)。
    public static ArrayList<Integer> subarraySumA(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        int len = nums.length;

        int sum = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == 0) {
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
            sum = 0;
        }

        return list;

    }

    //第二种思路：利用一个map记录从第一个元素开始到当前元素之和以及当前元素的下标，
    //如果后面的连续元素之和为零那么sum不变，此时就找到了和为零的连续序列，时间复杂度是O(n)
    public static ArrayList<Integer> subarraySumB(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        int len = nums.length;

        int sum = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        for (int i=0;i<len;i++) {
            sum += nums[i];
            if (hashMap.containsKey(sum)) {
                list.add(hashMap.get(sum) + 1);
                list.add(i);
                return list;
            }
            hashMap.put(sum, 1);
        }


        return list;

    }


    public static void main(String[] args) {

        int[] array = new int[]{-3, 1, 2, -3, 4};

        List<Integer> listA = subarraySumA(array);

        if (listA.size() == 2) {
            int headIndex = listA.get(0);
            int tailIndex = listA.get(1);
            System.out.println(headIndex + ":" + tailIndex);
        }


        List<Integer> listB = subarraySumB(array);

        if (listB.size() == 2) {
            int headIndex = listB.get(0);
            int tailIndex = listB.get(1);
            System.out.println(headIndex + ":" + tailIndex);
        }

    }
}
