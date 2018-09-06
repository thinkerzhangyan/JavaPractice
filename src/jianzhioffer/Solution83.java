package jianzhioffer;

import java.util.HashMap;

/**
 * @author zhangyan
 * @date 2018/8/30
 * @des 给出一个数组 nums 包含 n + 1 个整数，每个整数是从 1 到 n (包括边界)，
 * 保证至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 注意事项
 * 1.不能修改数组(假设数组只能读)
 * 2.只能用额外的O(1)的空间
 * 3.时间复杂度小于O(n^2)
 * 4.数组中只有一个重复的数，但可能重复超过一次
 * <p>
 * 样例
 * <p>
 * 给出 nums = [5,5,4,3,2,1]，返回 5.
 * 给出 nums = [5,4,4,3,2,1]，返回 4.
 */
public class Solution83 {

    /********************************不符合要求的方法****************************************/

    //1 O(N*N) 两层遍历
    public int duplicateA(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(numbers[i])) {
                return numbers[i];
            } else {
                hashMap.put(numbers[i], 1);
            }
        }

        return -1;
    }

    //2 先排序，然后查找，时间复杂度O(NlogN)，空间O(1)
    public int duplicateB(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }


        return -1;

    }

    //3 利用Hash，时间复杂度O(N),空间复杂度O(N)
    public int duplicateC(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(numbers[i])) {
                return numbers[i];
            } else {
                hashMap.put(numbers[i], 1);
            }
        }

        return -1;
    }


    //4 利用bit-map 该方法使用了辅助空间，时间复杂度O(N)，空间复杂度....
    public int duplicateD(int[] numbers) {

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

    //5 50中的最优的方法


    /*********************************符合要求的方法******************************************/

    // 5
    //
    // O(logN)  O(1)
    //
    // 思路
    //
    // https://www.jianshu.com/p/f0bec6ae99ee?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
    // http://www.cnblogs.com/grandyang/p/4843654.html
    //
    // 在区间[1, n]中搜索，首先求出中点mid，然后遍历整个数组，统计所有小于等于mid的数的个数，
    // 如果个数大于mid，则说明重复值在[mid+1, n]之间，反之，重复值应在[1, mid-1]之间，
    // 然后依次类推，直到搜索完成，此时的low就是我们要求的重复值，参见代码如下：
    //
    public int duplicateE(int[] nums) {
        int low = 1, high = nums.length - 1;
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

    // 6
    //
    // O(N)  O(1)
    //
    // 思路
    //
    // https://www.jianshu.com/p/f0bec6ae99ee?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation
    // http://www.cnblogs.com/grandyang/p/4843654.html
    // https://www.jianshu.com/p/a388d91141af
    //
    // 题中所给数组可以看成链表（不一定是一条链），其中下标为节点地址，元素值为下一节点地址next。
    // 由于每个节点都有下一节点，即next都不为空，故链表一定有环。
    // 由于元素范围为[1, n]，故下标为0的节点nums[0]不会作为其他节点的下一节点next，因此从0节点开始的链表中一定会存在两个节点的next相同，
    // 这个next即为要找的出现两次以上的元素，也就是链表中环的起点。直接套用龟兔算法即可。
    //

    public int duplicateF(int[] nums) {
        if (nums.length <= 1)
            return -1;

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }


    public static void main(String[] args) {

       // int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 5, 5};
        int[] numbers = new int[]{1, 2, 2,3, 4};


        Solution83 solution82 = new Solution83();

        System.out.println(solution82.duplicateA(numbers));
        System.out.println(solution82.duplicateB(numbers));
        System.out.println(solution82.duplicateC(numbers));
        System.out.println(solution82.duplicateD(numbers));
        System.out.println(solution82.duplicateE(numbers));
        System.out.println(solution82.duplicateF(numbers));

    }
}
