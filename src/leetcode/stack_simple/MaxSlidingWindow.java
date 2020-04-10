package leetcode.stack_simple;

import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindowA(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (nums.length <= k) {
            int[] targetNums = new int[1];
            targetNums[0] = nums[0];
            for (int index = 1; index < nums.length; index++) {
                if (targetNums[0] < nums[index]) {
                    targetNums[0] = nums[index];
                }
            }
            return targetNums;
        } else {
            int targetLen = nums.length - k + 1;
            int[] targetNums = new int[targetLen];
            for (int index = 0; index < targetLen; index++) {
                targetNums[index] = nums[index];
                for (int interIndex = index; interIndex < index + k; interIndex++) {
                    if (targetNums[index] < nums[interIndex]) {
                        targetNums[index] = nums[interIndex];
                    }
                }
            }
            return targetNums;
        }
    }

    public int[] maxSlidingWindowB(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        return nums;
    }

}
