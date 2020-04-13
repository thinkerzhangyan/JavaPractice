package leetcode.stack.stack_simple;

public class MaxStackQueue {

    private MaxStack stackOne = new MaxStack();
    private MaxStack stackTwo = new MaxStack();


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
        return stackTwo.top();
    }

    public synchronized int max() {
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            return stackTwo.max();
        }
        if (stackOne.isEmpty()) {
            return stackTwo.max();
        }
        return stackTwo.max() > stackOne.max() ? stackTwo.max() : stackOne.max();
    }


}
