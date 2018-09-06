package shujujiegoulianxi;

/**
 * @author zhangyan
 * @date 2018/5/15
 * @des
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private static class BinaryNode<E> {

        private E element;
        private BinaryNode<E> leftChild;
        private BinaryNode<E> rightChild;

        public BinaryNode(E x) {
            this(x, null, null);
        }

        public BinaryNode(E x, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
            this.element = x;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private BinaryNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean contains(E element) {
        return contains(element, root);
    }

    public boolean contains(E element, BinaryNode<E> root) {
        if (root == null) {
            return false;
        }

        int result = element.compareTo(root.element);

        if (result < 0) {
            return contains(element, root.leftChild);
        } else if (result > 0) {
            return contains(element, root.rightChild);
        } else
            return true;

        //可以用while循环

    }


    public E findMin() {
        return findMin(root).element;
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
        return findMax(root).element;
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
            System.out.println(root.element);
            printTree(root.rightChild);
        }
    }

    public void insert(E element) {
        root = insert(element, root);
    }

    public BinaryNode<E> insert(E element, BinaryNode<E> root) {
        if (root == null) {
            return new BinaryNode<>(element, null, null);
        }

        int result = element.compareTo(root.element);

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
        root = remove(element, root);
    }

    public BinaryNode<E> remove(E element, BinaryNode<E> root) {

        if (root == null) {
            return null;
        }
        int result = element.compareTo(root.element);
        if (result < 0) {
            root.leftChild = remove(element, root.leftChild);
        } else if (result > 0) {
            root.rightChild = remove(element, root.rightChild);
        } else if (root.leftChild != null && root.rightChild != null) {
            root.element = findMin(root.rightChild).element;
            root.rightChild = remove(root.element, root.rightChild);
        } else {
            root = root.leftChild != null ? root.leftChild : root.rightChild;
        }
        return root;
    }



    public int height() {
        return height(root);
    }

    private int height(BinaryNode<E> root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.leftChild);
        int right = height(root.rightChild);

        return left > right ? left + 1 : right + 1;
    }

    public int size() {
        return size(root);
    }

    private int size(BinaryNode<E> root) {
        if (root == null) {
            return 0;
        }
        return size(root.leftChild) + 1 + size(root.rightChild);
    }

}
