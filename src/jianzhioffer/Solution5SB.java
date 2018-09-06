package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution5SB {


    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(Integer val) {
        if (queue1.isEmpty()) {
            queue1.add(val);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
        } else {
            queue2.add(val);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }
    }

    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalStateException("Stack is Empty!!!!");
        } else if (!queue1.isEmpty()) {
            return queue1.poll();
        } else {
            return queue2.poll();
        }
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        Solution5SB mySelfStack = new Solution5SB();
        for (int i=0;i<10;i++) {
            mySelfStack.push(i);
        }
        while (!mySelfStack.isEmpty()) {
            System.out.println(mySelfStack.pop());
        }
    }

}
