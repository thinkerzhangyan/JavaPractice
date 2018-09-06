package shujujiegoulianxi;

import jdk.nashorn.internal.objects.NativeUint8Array;

public class QuadraticProbingHashTable<E> {

    private static class HashEntry<E> {
        public boolean isActive;
        public E item;

        public HashEntry(E item) {
            this(item, true);
        }

        public HashEntry(E item, boolean isActive) {
            this.item = item;
            this.isActive = isActive;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private HashEntry<E>[] array;

    private int currentSize;
    private int occupiedSize;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        array = new HashEntry[nextPrime(size)];
        makeEmpty();
    }

    public void makeEmpty() {
        for (int i=0;i<array.length;i++) {
            array[i] = null;
        }
        currentSize = 0;
        occupiedSize = 0;
    }


    public boolean contain(E x) {
        int pos = findPos(x);
        return isActive(pos);
    }

    private int findPos(E x) {

        int offset=1;
        int pos = myHash(x);

        while (array[pos] != null && !array[pos].item.equals(x)) {
            pos += offset;
            offset += 2;
            if (pos >= array.length) {
                pos -= array.length;
            }
        }

        return pos;
    }

    private boolean isActive(int pos) {
        return array[pos] != null && array[pos].isActive;
    }

    public boolean add(E x) {
        if (contain(x)) {
            return false;
        }

        int pos = findPos(x);
        array[pos] = new HashEntry<E>(x, true);
        currentSize++;
        occupiedSize++;
        if (occupiedSize >= array.length / 2) {
            rehash();
        }
        return true;
    }

    public boolean remove(E x) {
        if (!contain(x)) {
            return false;
        }
        int pos = findPos(x);
        array[pos].isActive = false;
        currentSize--;
        return true;
    }

    private void rehash() {

        HashEntry<E>[] oldArray = array;
        array = new HashEntry[nextPrime(array.length * 2)];
        currentSize = 0;
        occupiedSize = 0;
        for (HashEntry<E> entry : oldArray) {
            if (entry!=null&&entry.isActive) {
                add(entry.item);
            }
        }
    }

    public int myHash(E x) {
        int hashVal = x.hashCode();
        hashVal = hashVal % array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    public static int hash(String key, int tableSize) {

        int hashVal = 0;

        for (int i = 0; i < key.length(); i++) {
            hashVal = hashVal * 37 + key.charAt(i);
        }
        hashVal %= tableSize;
        if (hashVal < 0) {
            hashVal += tableSize;
        }
        return hashVal;
    }


    private int nextPrime(int n) {

        if (n % 2 == 0) {
            n++;
        }

        for (; !isPrime(n); n += 2) {

        }
        return n;
    }

    private boolean isPrime(int n) {

        if (n == 1 || n % 2 == 0) {
            return false;
        }

        if (n == 2 || n == 3) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


}
