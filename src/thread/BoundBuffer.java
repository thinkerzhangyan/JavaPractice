package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by macbook on 2017/10/9.
 */
public class BoundBuffer {

    private Lock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    int putPtr = 0, takePtr = 0, count = 0;

    Object[] items = new Object[100];

    public void put(Object item) {

        lock.lock();
        try {

            while (count == items.length) {
                notFull.await();
            }

            items[putPtr++] = item;

            if (putPtr == items.length) {
                putPtr = 0;
            }
            count++;
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public Object get() {
        Object item = null;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }

            item = items[takePtr++];

            if (takePtr == items.length) {
                takePtr = 0;
            }
            count--;
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }

    public static void main(String[] args) {

    }

}
