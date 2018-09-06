package jianzhioffer;

import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 栈的压入，弹出序列。
 */
public class Solution21 {
    public boolean isPopOrder(int[] push, int[] pop) {

        if (push == null || push.length == 0 || pop == null || pop.length == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for(int i=0;i<push.length;i++) {
            stack.push(push[i]);
            while (j < pop.length && stack.peek() == pop[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

}
