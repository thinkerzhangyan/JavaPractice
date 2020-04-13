package leetcode.stack.stack_simple;

import java.util.LinkedList;

public class StackQueue {

    private LinkedList<Integer> stackOne = new LinkedList<>();
    private LinkedList<Integer> stackTwo = new LinkedList<>();

    public synchronized void push(int x) {
        stackOne.push(x);
    }

    public synchronized int pop() {
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.pop();
    }

    public boolean empty() {
        return stackTwo.isEmpty() && stackOne.isEmpty();
    }

    public synchronized int peek() {
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        return stackTwo.peek();
    }
}
