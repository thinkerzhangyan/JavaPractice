package leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangyan
 * @date 2020/6/2
 * @des 数组中的第K个最大元素
 */
public class KTthNumber {

    public static void main(String[] args) {
        System.out.println(findKthLargestA(new int[]{1,2,3,4,5,6},1));
        System.out.println(findKthLargestB(new int[]{1,2,3,4,5,6},1));
    }

    //时间复杂度 O(N) 空间O(1)
    public static int findKthLargestA(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k <= 0) {
            return 0;
        }

        int head = 0;
        int tail = nums.length - 1;

        int target = nums.length - k;

        while (true) {
            int j = partitionB(nums, head, tail);
            if (j == target) {
                return nums[j];
            } else if (j < target) {
                head = j + 1;
            } else {
                tail = j - 1;
            }
        }
    }

    //时间复杂度 O(NlogN) 空间O(N)
    public static int findKthLargestB(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k <= 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    private static int partitionA(int[] a, int lo, int hi) {

        int i = lo,j=hi+1;

        int v = a[lo];

        while(true){

            while(less(a[++i],v)) if(i==hi) break;
            while(less(v,a[--j])) if(j==lo) break;

            if(i>=j) break;

            exch(a,i,j);
        }

        exch(a,lo,j);

        return j;

    }

    public static int partitionB(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                exch(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        exch(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }




    private static boolean less(int a, int b) {
        return a < b;
    }

    private static void exch(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
