package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyan
 * @date 2018/4/8
 * @des
 */
public class BoundBufferPractice<T> {


    public static void main(String[] args) {

    }

    private Object[] items = new Object[100];

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private int putPtr,takePtr, count = 0;

    public void put(Object item) throws InterruptedException {

        lock.lock();

        try {

            while (count == items.length) {
                notFull.await();
            }

            items[putPtr++] = item;

            if(putPtr==items.length) putPtr = 0;

            count++;

            notEmpty.signalAll();

        }finally {
            lock.unlock();
        }

    }

    public Object get() throws InterruptedException {

        Object item=null;

        lock.lock();

        try {

            while (count == 0) {
                notEmpty.await();
            }

            item = items[takePtr++];

            if(takePtr==items.length) takePtr = 0;

            count--;

            notFull.signalAll();

        }finally {
            lock.unlock();
        }


        return item;
    }


}