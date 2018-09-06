package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/4/16
 * @des 自己实现一个队列
 */
public class MySelfQueue<T> {

    private QueueItem<T> head;
    private QueueItem<T> tail;

    public synchronized void enqueue(T item) {

        if (head == null) {
            head = tail = new QueueItem<>(item);
        } else if (tail != null) {
            tail.next = new QueueItem<>(item);
            tail = tail.next;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }

    public synchronized T poll() {

        QueueItem<T> item = head;

        if (head != null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }

        if (item == null) {
            return null;
        } else {
            return item.value;
        }
    }


    public synchronized T poll(int maxTime) throws InterruptedException {
        if (head == null) {
            wait(maxTime);
        }
        return poll();
    }


    public static void main(String[] args) {

        MySelfQueue<Integer> solution0 = new MySelfQueue<>();

        for (int i = 0; i < 10; i++) {
            solution0.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(solution0.poll());
        }

        MySelfQueue<String> solution1 = new MySelfQueue<>();

        for (int i = 0; i < 10; i++) {
            solution1.enqueue(i+"haha");
        }
 
        for (int i = 0; i < 10; i++) {
            System.out.println(solution1.poll());
        }

    }

}

class QueueItem<T> {

    public  T value;
    public QueueItem<T> next;

    public QueueItem(T value) {
        this.value=value;
    }
}

