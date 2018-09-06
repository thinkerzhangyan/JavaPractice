package shujujiegoulianxi;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author zhangyan
 * @date 2018/5/21
 * @des
 */

public class MyLinkedList<T> implements Iterable<T> {

    private static class Node<T> {

        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }


    private int modCount = 0;

    private int currentSize;

    private Node<T> beginMarker;
    private Node<T> endMarker;


    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        currentSize = 0;
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        currentSize = 0;
        modCount++;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }


    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<T>(x, p.prev, p);
        p.prev.next = newNode;
        p.prev = newNode;
        modCount++;
        currentSize++;
    }


    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> node = getNode(idx);
        T oldVal = node.data;
        node.data = newVal;
        return oldVal;
    }

    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }


    private Node<T> getNode(int idx, int lower, int upper) {

        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> p;

        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }

        return p;

    }


    public T remove(int idx) {
        return remove(getNode(idx));
    }

    public T remove(Node<T> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        modCount++;
        currentSize--;
        return p.data;
    }

    @Override
    public Iterator<T> iterator() {

        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private int expectedModCount = modCount;

        private boolean isOkToRemove = false;
        private Node<T> current = beginMarker.next;


        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {

            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            isOkToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!isOkToRemove) {
                throw new IllegalStateException();
            }
            isOkToRemove = false;
            expectedModCount++;
            MyLinkedList.this.remove(current.prev);
        }
    }


}
