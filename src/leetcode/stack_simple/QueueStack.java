package leetcode.stack_simple;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public QueueStack() {
    }

    public void push(int val) {
        if (queue1.isEmpty()) {
            queue1.add(val);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        } else if (queue2.isEmpty()) {
            queue2.add(val);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }
    }

    public int pop() {
        if (queue1.isEmpty()) {
            return queue2.poll();
        } else {
            return queue1.poll();
        }
    }


    public int top() {
        if (queue1.isEmpty()) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
