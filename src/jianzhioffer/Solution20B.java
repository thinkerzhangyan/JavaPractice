package jianzhioffer;

import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 包含min函数的栈
 */
public class Solution20B {

    private Stack<Integer> stackOne = new Stack<>();
    private Stack<Integer> stackTwo = new Stack<>();

    public void push(int node) {

        stackOne.push(node);
        if (stackTwo.isEmpty()) {
            stackTwo.push(node);
        } else if (stackTwo.peek() <= node) {
            stackTwo.push(stackTwo.peek());
        } else {
            stackTwo.push(node);
        }

    }

    public int pop() {
        stackTwo.pop();
        return stackOne.pop();
    }

    public int min() {
        return stackTwo.peek();
    }

    public int top() {
        return stackOne.pop();
    }



}


