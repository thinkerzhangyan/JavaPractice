package thread;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by macbook on 2017/10/9.
 */
public class Test {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        CompletionService completionService = new ExecutorCompletionService(Executors.newFixedThreadPool(3));
    }

    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Object get(String key) throws Exception {

        readWriteLock.readLock().lock();

        Object value = null;

        try {

            value = map.get(key);
            if (value == null) {
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try {
                    value = "";
                    if (value == null) {
                        throw new Exception("value wei kong!");
                    }
                    map.put(key, value);
                } finally {
                    readWriteLock.writeLock().unlock();
                }
                readWriteLock.readLock().lock();
            }


        } finally {
            readWriteLock.readLock().unlock();
        }

        return value;
    }

    public static int hash(String key, int tableSize) {

        int hashVal = 0;

        for (int i=0;i<key.length();i++) {
            hashVal = key.charAt(i) + hashVal * 37;
        }

        hashVal %= tableSize;

        if (hashVal < 0) {
            hashVal += tableSize;
        }

        return hashVal;
    }


}

