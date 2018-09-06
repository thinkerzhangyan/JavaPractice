package shujujiegoulianxi;

/**
 * @author zhangyan
 * @date 2018/5/12
 * @des
 */
public class BinaryHeap<E extends Comparable<? super Comparable> >{

    private static final int DEFAULT_HEAP_SIZE = 10;

    private int currentSize;
    private E[] array;

    public BinaryHeap() {
        this(DEFAULT_HEAP_SIZE);
    }

    public BinaryHeap(int size) {
        array = (E[]) new Comparable[size+1];
        currentSize = 0;
    }

    public BinaryHeap(E[] items) {
        currentSize = items.length;
        array = (E[]) new Comparable[items.length + 1];
        int i = 1;
        for (E e : items) {
            array[i++] = e;
        }
        buildHeap();
    }

    private void buildHeap() {
        for (int i=array.length/2;i>0;i--) {
            percolateDown(i);
        }
    }

    public void add(E x) {
        if (currentSize == array.length-1) {
            enlargeArray();
        }
        int hole = ++currentSize;
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    private void enlargeArray() {
        E[] oldArray = array;
        array = (E[]) new Comparable[array.length * 2 + 1];
        int i = 0;
        for (E item : oldArray) {
            array[i++]=item;
        }
    }

    private boolean isEmpty() {
        return currentSize==0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    public E findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("isEmpty!");
        }
        return array[1];

    }

    public E deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("isEmpty!");
        }
        E min = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole) {

        E tmp = array[hole];

        int child=0;

        for (;hole*2<=currentSize;hole=child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }




}
