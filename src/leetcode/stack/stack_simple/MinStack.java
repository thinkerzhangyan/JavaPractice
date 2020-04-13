package leetcode.stack.stack_simple;

import java.util.LinkedList;

public class MinStack {

    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty()) {
            stack2.push(val);
        } else {
            if (stack2.peek() < val) {
                stack2.push(stack2.peek());
            } else {
                stack2.push(val);
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

    public int getMin() {
        return stack2.peek();
    }

}
