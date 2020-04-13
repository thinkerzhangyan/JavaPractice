package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 用两个栈实现一个最大值队列
 */
public class MaxQueue {

    private MaxStack stack1 = new MaxStack();
    private MaxStack stack2 = new MaxStack();

    public void push(int val) {
        stack1.push(val);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()) {
            return -1;
        }
        return stack2.pop();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public int top() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()) {
            return -1;
        }
        return stack2.top();
    }

    public int max() {
        if (stack1.empty() && stack2.empty()) {
            return -1;
        }
        if (stack1.empty()) {
            return stack2.max();
        }
        if (stack2.empty()) {
            return stack1.max();
        }
        return stack1.max() > stack2.max() ? stack1.max() : stack2.max();
    }

}
