/**
 * @author zhangyan
 * @date 2018/4/16
 * @des 自己实现一个队列
 */
public class Queue<T> {

    private QueueItem<T> head;
    private QueueItem<T> tail;

    public synchronized void enqueue(T val) {

        if (head == null) {
            head = tail = new QueueItem<T>(val);
        } else if (tail != null) {
            tail.next = new QueueItem<T>(val);
            tail = tail.next;
        } else {
            throw new IllegalStateException("Illegal State");
        }
        notifyAll();
    }

    public synchronized T poll() {

        T val=null;

        if (head != null) {
            val = head.val;
            head = head.next;
            if (head == null) {
                head = tail = null;
            }
        }

        return val;

    }

    public synchronized T poll(int maxTime) throws InterruptedException {
        if (head == null) {
            wait(maxTime);
        }
        return poll();
    }

    public static void main(String[] args) {

        Queue<Integer> solution0 = new Queue<>();

        for (int i = 0; i < 10; i++) {
            solution0.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(solution0.poll());
        }

        Queue<String> solution1 = new Queue<>();

        for (int i = 0; i < 10; i++) {
            solution1.enqueue(i + "haha");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(solution1.poll());
        }

    }

}

class QueueItem<T> {
    T val;
    QueueItem<T> next;

    public QueueItem(T val) {
        this.val = val;
    }
}


