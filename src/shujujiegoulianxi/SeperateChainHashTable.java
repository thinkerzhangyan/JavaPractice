package shujujiegoulianxi;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/5/11
 * @des
 */
public class SeperateChainHashTable<E> {

    private static final int DEFAULT_TABLE_SIZE=101;

    private int currentSize;
    private LinkedList<E>[] array;


    public SeperateChainHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeperateChainHashTable(int currentSize) {
        array = new LinkedList[nextPrime(currentSize)];
        currentSize = 0;
        for (int i=0;i<array.length;i++) {
            array[i] = new LinkedList<E>();
        }
    }

    public boolean contain(E x) {
        int pos = myHash(x);
        return array[pos].contains(x);
    }

    public void add(E x) {
        int pos = myHash(x);
        array[pos].add(x);
        if (++currentSize >= array.length / 2) {
            rehash();
        }
    }

    public void remove(E x) {
        if (contain(x)) {
            array[myHash(x)].remove(x);
            currentSize--;
        }
    }

    public void makeEmpty() {
        for (int i = 0; i < array.length; i++) {
            array[i].clear();
            array[i] = null;
        }
        currentSize = 0;
    }

    public static int hash(String key, int tableSize) {

        int hashVal=0;

        for (int i = 0; i < key.length(); i++) {
            hashVal = hashVal * 37 + key.charAt(i);
        }
        hashVal %= tableSize;
        if (hashVal < 0) {
            hashVal += tableSize;
        }
        return hashVal;
    }

    public void rehash() {
        LinkedList<E>[] oldArray = array;
        array = new LinkedList[nextPrime(array.length * 2)];
        for (int i=0;i<array.length;i++) {
            array[i] = new LinkedList<E>();
        }
        currentSize = 0;
        for (List<E> list : oldArray) {
            for (E x : list) {
                add(x);
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



    private int nextPrime(int n) {

        if (n % 2 == 0) {
            n++;
        }

        for (;!isPrime(n);n+=2) {

        }
        return n;
    }

    private boolean isPrime(int n){

        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


    private boolean isPrimeB(int n) {

        if (n < 2) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0) {
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
