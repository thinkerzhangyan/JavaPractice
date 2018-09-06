package shujujiegoulianxi;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] theItems;
    private int currentSize;

    private int modCount = 0;

    public MyArrayList() {
        doClear();
    }


    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }


    public T get(int idx) {
        if (idx < 0 || idx >= theItems.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }


    public T set(int idx, T x) {
        if (idx < 0 || idx >= theItems.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldVal = theItems[idx];
        theItems[idx] = x;
        return oldVal;
    }


    private void ensureCapacity(int newSize) {
        if (newSize <= currentSize) {
            return;
        }
        T[] oldItems = theItems;
        theItems = (T[]) new Object[newSize];
        for (int i = 0; i < currentSize; i++) {
            theItems[i] = oldItems[i];
        }
        oldItems = null;
    }


    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    private void add(int idx, T x) {
        if (currentSize == theItems.length) {
            ensureCapacity(currentSize * 2 + 1);
        }
        for (int i = currentSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        modCount++;
        currentSize++;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= theItems.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T removeItem = theItems[idx];
        for (int i = idx; i < currentSize - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        currentSize--;
        modCount++;
        return removeItem;

    }


    public void clear() {
        doClear();
    }

    private void doClear() {
        currentSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }


    private class ArrayListIterator implements Iterator<T> {

        private int expectedModCount = 0;

        private boolean isOkToRemove = false;
        private int current;

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return current < currentSize;
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T val = theItems[current++];
            isOkToRemove = true;
            return val;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!isOkToRemove) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(--current);
            expectedModCount++;
            isOkToRemove = false;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

}

