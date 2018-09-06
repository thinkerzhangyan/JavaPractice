package mianshizhenti;

/**
 * @author zhangyan
 * @date 2018/8/18
 * @des 实现一个栈
 */
public class MySelfStack<T> {


    private static int DEFAULT_SIZE = 16;

    private T[] array;


    private int index = 0;

    public MySelfStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public MySelfStack() {
        this(DEFAULT_SIZE);
    }

    public void push(T val) {
        if (index == array.length) {
            resize(array.length * 2);
        }
        array[index++] = val;
    }

    public T pop() throws Exception {
        if (index <= 0) {
            throw new Exception("Stack is Empty");
        }
        return array[--index];
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i=0;i<index;i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private boolean isEmpty() {
        return index == 0;
    }

    public static void main(String[] args) throws Exception {
        MySelfStack<Integer> mySelfStack = new MySelfStack<>();
        for (int i=0;i<10;i++) {
            mySelfStack.push(i);
        }
        while (!mySelfStack.isEmpty()) {
            System.out.println(mySelfStack.pop());
        }
    }
}


