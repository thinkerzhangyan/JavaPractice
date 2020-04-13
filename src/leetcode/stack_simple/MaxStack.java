package leetcode.stack_simple;

import java.util.LinkedList;

public class MaxStack {

    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();

    public MaxStack() {

    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty()) {
            stack2.push(val);
        } else {
            if (stack2.peek() > val) {
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

    public int max() {
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
