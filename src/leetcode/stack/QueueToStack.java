package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 用两个队列实现一个栈
 */
public class QueueToStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {

        if (queue1.isEmpty()) {
            queue1.add(node);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        } else {
            queue2.add(node);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }

    }

    public int pop() throws Exception {

        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new Exception("Stack is Empty.");
        } else if (!queue1.isEmpty()) {
            return queue1.poll();
        } else {
            return queue2.poll();
        }

    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public Integer top() {
        if (queue1.isEmpty()) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }
    }


}
