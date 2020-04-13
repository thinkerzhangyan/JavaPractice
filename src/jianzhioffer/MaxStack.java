package jianzhioffer;

import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 包含max函数的栈
 */
public class MaxStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty()) {
            stack2.push(val);
        } else {
            if (stack2.peek() < val) {
                stack2.push(val);
            } else {
                stack2.push(stack2.peek());
            }
        }
    }

    public int pop() {
        stack2.pop();
        return stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int max() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
