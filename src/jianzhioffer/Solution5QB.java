package jianzhioffer;

import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/4/19
 * @des
 */
public class Solution5QB {

    private Stack<Integer> stackOne = new Stack<>();
    private Stack<Integer> stackTwo = new Stack<>();


    public void enqueue(Integer val) {
        stackOne.push(val);
    }

    public Integer poll() {
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            return stackTwo.pop();
        } else {
            return stackTwo.pop();
        }
    }
}
