package leetcode.stack_simple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class NextGreaterNumber {
    public int[] nextGreaterNumOne(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            boolean isCompare = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    isCompare = true;
                }
                if (isCompare) {
                    if (nums1[i] < nums2[j]) {
                        result[i] = nums2[j];
                        break;
                    }
                }
            }
        }

        return result;
    }

    public int[] nextGreaterNumTwo(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return nums1;
        }
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                hashMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}

