package leetcode.stack.stack_simple;

import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindowA(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (k < 1) {
            return new int[0];
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
        if (k < 1) {
            return new int[0];
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
            MaxStackQueue maxStackQueue = new MaxStackQueue();
            int targetLen = nums.length - k + 1;
            int[] targetNums = new int[targetLen];
            for (int index=0;index<k;index++) {
                maxStackQueue.push(nums[index]);
            }
            targetNums[0] = maxStackQueue.max();
            maxStackQueue.pop();
            int j = 1;
            for (int index = k; index < nums.length; index++) {
                if (j < targetLen) {
                    maxStackQueue.push(nums[index]);
                    targetNums[j] = maxStackQueue.max();
                    maxStackQueue.pop();
                    j++;
                } else {
                    break;
                }
            }
            return targetNums;
        }
    }

    public int[] maxSlidingWindowC(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (k < 1) {
            return new int[0];
        }
        if (nums.length < k) {
            int[] targetNums = new int[1];
            targetNums[0] = nums[0];
            for (int index = 1; index < nums.length; index++) {
                if (targetNums[0] < nums[index]) {
                    targetNums[0] = nums[index];
                }
            }
            return targetNums;
        } else {
            int index = 0;
            int[] targetNumers = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i=0;i<nums.length;i++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
                if (queue.peekFirst() == i - k) {
                    queue.pollFirst();
                }
                if (i >= k - 1) {
                    targetNumers[index++] = nums[queue.peekFirst()];
                }
            }
            return targetNumers;
        }
    }

}
