package jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/8/19
 * @des 子数组之和
 *
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 样例给出[-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
 *
 * 参考链接：
 *         https://www.jianshu.com/p/b3e22a80dbd6
 *         https://blog.csdn.net/ljlstart/article/details/48393675
 *         https://www.cnblogs.com/theskulls/p/4872718.html
 *
 */
public class Solution85 {


    //第一种思路：利用两个for循环，每次取出一个元素依次与后面的元素相加，时间复杂度是O(n^2)，空间复杂度为O(1)。
    public static ArrayList<ArrayList<Integer>> subarraySumA(int[] nums) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return lists;
        }

        int len = nums.length;

        int sum = 0;

        for (int i = 0; i < len; i++) {
            for (int j=i;j<len;j++) {
                sum += nums[j];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
            sum = 0;
        }

        return lists;
    }

    //第二种思路：利用一个map记录从第一个元素开始到当前元素之和以及当前元素的下标，
    //如果后面的连续元素之和为零那么sum不变，此时就找到了和为零的连续序列，时间复杂度是O(n*n)，空间复杂度为O(n)
    public static ArrayList<ArrayList<Integer>> subarraySumB(int[] nums) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return lists;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// 第一个元素为 0 id 应该为-1

        int len = nums.length;

        int sum = 0;

        for (int i = 0; i < len; i++) {
            for (int j=i;j<len;j++) {
                sum += nums[j];
                if (map.containsKey(sum)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(map.get(sum) + 1);
                    list.add(i);
                    lists.add(list);
                }
                map.put(sum, j);
                map.clear();
                break;
            }
        }

        return lists;
    }


    public static void main(String[] args) {

        int[] array = new int[]{-3, 1, 2, -3, 4};

        ArrayList<ArrayList<Integer>> listsA = subarraySumA(array);

        for (ArrayList list : listsA) {

            if (list.size() == 2) {
                int headIndex = (int) list.get(0);
                int tailIndex = (int) list.get(1);
                System.out.println(headIndex + ":" + tailIndex);
            }

        }

        ArrayList<ArrayList<Integer>> listsB = subarraySumB(array);

        for (ArrayList list : listsA) {

            if (list.size() == 2) {
                int headIndex = (int) list.get(0);
                int tailIndex = (int) list.get(1);
                System.out.println(headIndex + ":" + tailIndex);
            }

        }

    }
}
