package jianzhioffer;

import java.util.Stack;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 用两个栈实现一个队列
 */
public class StackToQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public void push(int val) {
        stack1.push(val);
    }

    public int pop() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
