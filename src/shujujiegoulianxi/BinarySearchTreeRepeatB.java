package shujujiegoulianxi;

import java.util.LinkedList;

/**
 * @author zhangyan
 * @date 2018/5/15
 * @des
 */
public class BinarySearchTreeRepeatB<E extends Comparable<? super E>>{

    private static class BinaryNode<E>{

        private LinkedList<E> elements;

        private BinaryNode<E> leftChild;
        private BinaryNode<E> rightChild;

        public BinaryNode(E x) {
            this(x,null, null);
        }

        public BinaryNode(E x, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
            this.elements.add(x);
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private BinaryNode<E> root;

    public BinarySearchTreeRepeatB() {
        root = null;
    }

    public boolean contains(E element) {
        return contains(element, root);
    }

    public boolean contains(E element,BinaryNode<E> root) {
        if (root == null) {
            return false;
        }

        int result = element.compareTo(root.elements.get(0));

        if (result < 0) {
            return contains(element, root.leftChild);
        } else if (result > 0) {
            return contains(element, root.rightChild);
        }else
            return true;

        //可以用while循环

    }


    public E findMin() {
        return findMin(root).elements.get(0);
    }

    public BinaryNode<E> findMin(BinaryNode<E> root) {
        if (root == null) {
            return null;
        }

        if (root.leftChild == null) {
            return root;
        }
        return findMin(root.leftChild);
    }

    public E findMax() {
        return findMax(root).elements.get(0);
    }

    public BinaryNode<E> findMax(BinaryNode<E> root) {
        if (root == null) {
            return null;
        }
        if (root.rightChild != null) {
            while (root.rightChild != null) {
                root = root.rightChild;
            }
        }
        return root;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty Tree!!!!");
        }
        printTree(root);
    }

    private void printTree(BinaryNode<E> root) {
        if (root != null) {
            printTree(root.leftChild);
            System.out.println(root.elements.get(0));
            printTree(root.rightChild);
        }
    }

    public void insert(E element) {
        root = insert(element, root);
    }

    public BinaryNode<E> insert(E element, BinaryNode<E> root) {
        if (root == null) {
            return new BinaryNode<E>(element, null, null);
        }

        int result = element.compareTo(root.elements.get(0));

        if (result < 0) {
            root.leftChild = insert(element, root.leftChild);
        } else if (result > 0) {
            root.rightChild = insert(element, root.rightChild);
        } else {
        }
        return root;
        //重复元的插入
    }

    public void remove(E element) {
        root=remove(element, root);
    }

    public BinaryNode<E> remove(E element, BinaryNode<E> root) {

        if (root == null) {
            return null;
        }
        int result = element.compareTo(root.elements.get(0));
        if (result < 0) {
            root.leftChild = remove(element, root.leftChild);
        } else if (result > 0) {
            root.rightChild = remove(element, root.rightChild);
        } else if (root.leftChild != null && root.rightChild != null) {
            if (root.elements.size() <= 1) {
                root.elements = findMin(root.rightChild).elements;
                findMin(root.rightChild).elements.clear();
                root.rightChild = remove(root.elements.get(0), root.rightChild);
            } else {
                root.elements.remove(element);
            }

        } else {
            if (root.elements.size() <= 1) {
                root = root.leftChild != null ? root.leftChild : root.rightChild;
            } else {
                root.elements.remove(element);
            }
        }
        return root;
    }


}
