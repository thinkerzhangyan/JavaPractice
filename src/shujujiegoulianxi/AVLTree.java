package shujujiegoulianxi;


/**
 * Created by zejian on 2016/12/25.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 * 平衡二叉搜索树(AVL树)
 */
public class AVLTree<T extends Comparable<? super T>> {


    private static class AVLNode<T> {

        private AVLNode<T> left;
        private AVLNode<T> right;

        private T data;

        private int height;

        public AVLNode(T data) {
            this(null, null, data);
        }

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data) {
            this(left, right, data, 0);
        }

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data, int height) {

            this.left = left;
            this.right = right;
            this.data = data;
            this.height = height;

        }

    }

    private AVLNode<T> root;

    public boolean isEmpty() {
        return root == null;
    }


    public int size() {
        return size(root);
    }


    public int size(AVLNode<T> subtree) {
        if (subtree == null) {
            return 0;
        } else {
            return size(subtree.left) + 1 + size(subtree.right);
        }
    }

    public int height() {
        return height(root);
    }

    public int height(AVLNode<T> p) {
        return p == null ? -1 : p.height;
    }


    /**
     * 插入方法
     *
     * @param data
     */
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data == null");
        }
        this.root = insert(data, root);
    }

    private AVLNode<T> insert(T data, AVLNode<T> p) {
        //说明已没有孩子结点,可以创建新结点插入了.
        if (p == null) {
            return new AVLNode<>(data);
        }

        int result = data.compareTo(p.data);

        if (result < 0) {//向左子树寻找插入位置
            p.left = insert(data, p.left);
            //插入后计算子树的高度,等于2则需要重新恢复平衡,由于是左边插入,左子树的高度肯定大于等于右子树的高度
            if (height(p.left) - height(p.right) == 2) {
                //判断data是插入点的左孩子还是右孩子
                if (data.compareTo(p.left.data) < 0) {
                    //进行右旋转
                    p = singleRotateLLToRight(p);
                } else {
                    //进行左右旋转
                    p = doubleRotateWithLR(p);
                }
            }
        } else if (result > 0) {//向右子树寻找插入位置
            p.right = insert(data, p.right);
            if (height(p.right) - height(p.left) == 2) {
                if (data.compareTo(p.right.data) < 0) {
                    //进行右左旋转
                    p = doubleRotateRL(p);
                } else {
                    //进行左旋转
                    p = singleRotateRRToLeft(p);
                }
            }
        } else {

        }
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }

    /**
     * 删除方法
     *
     * @param data
     */
    public void remove(T data) {
        if (data == null) {
            throw new RuntimeException("data == null");
        }
        this.root = remove(data, root);
    }

    /**
     * 删除操作
     *
     * @param data
     * @param p
     * @return
     */
    private AVLNode<T> remove(T data, AVLNode<T> p) {
        if (p == null) {
            return null;
        }
        int result = data.compareTo(p.data);

        //从左子树查找需要删除的元素
        if (result < 0) {
            p.left = remove(data, p.left);
            //检测是否平衡
            if (height((p.right)) - height(p.left) == 2) {
                AVLNode<T> currentNode = p.right;
                //判断需要那种旋转
                if (height(currentNode.left) > height(currentNode.right)) {
                    //右孩子的左子树比右子树高，相当于在右孩子的左子树进行了插入操作，此时进行RL双旋转
                    p = doubleRotateRL(p);
                } else {
                    //右孩子的左子树比右子树低，相当于在右孩子的右子树进行了插入操作，此时进行RR左旋转
                    p = singleRotateRRToLeft(p);
                }
            }

        }
        //从右子树查找需要删除的元素
        else if (result > 0) {
            p.right = remove(data, p.right);
            if (height(p.left) - height(p.right) == 2) {
                AVLNode<T> currentNode = p.left;
                //检测是否平衡
                if (height(currentNode.right) > height(currentNode.left)) {
                    //左孩子的右子树比左子树高，相当于在左孩子的右子树进行了插入操作，此时进行LR双旋转
                    p = doubleRotateWithLR(p);
                } else {
                    //左孩子的右子树比左子树低，相当于在左孩子的左子树进行了插入操作，此时进行LL单旋转
                    p = singleRotateLLToRight(p);
                }
            }
        }
        //已找到需要删除的元素,并且要删除的结点拥有两个子节点
        else if (p.right != null && p.left != null) {
            //寻找替换结点
            p.data = findMin(p.right).data;
            //移除用于替换的结点
            p.right = remove(p.data, p.right);
        } else {
            //只有一个孩子结点或者只是叶子结点的情况
            p = p.left != null ? p.left : p.right;
        }
        //更新高度值
        if (p != null) {
            p.height = Math.max(height(p.left), height(p.right)) + 1;
        }
        return p;
    }

    public T findMin() {
        return findMin(root).data;
    }


    /**
     * 查找最小值结点
     *
     * @param p
     * @return
     */
    private AVLNode<T> findMin(AVLNode<T> p) {
        if (p == null)//结束条件
            return null;
        else if (p.left == null)//如果没有左结点,那么t就是最小的
            return p;
        return findMin(p.left);
    }

    public T findMax() {
        return findMax(root).data;
    }

    /**
     * 查找最大值结点
     *
     * @param p
     * @return
     */
    private AVLNode<T> findMax(AVLNode<T> p) {
        if (p == null)
            return null;
        else if (p.right == null)//如果没有右结点,那么t就是最大的
            return p;
        return findMax(p.right);
    }


    public boolean contains(T data) {
        return data != null && contain(data, root);
    }

    public boolean contain(T data, AVLNode<T> subtree) {

        if (subtree == null)
            return false;

        int result = data.compareTo(subtree.data);

        if (result < 0) {
            return contain(data, subtree.left);
        } else if (result > 0) {
            return contain(data, subtree.right);
        } else {
            return true;
        }
    }

    public void clear() {
        this.root = null;
    }


    /**
     * 左左单旋转(LL旋转) w变为x的根结点, x变为w的右子树
     *
     * @param x
     * @return
     */
    private AVLNode<T> singleRotateLLToRight(AVLNode<T> x) {

        //把w结点旋转为根结点
        AVLNode<T> w = x.left;
        //同时w的右子树变为x的左子树
        x.left = w.right;
        //x变为w的右子树
        w.right = x;
        //重新计算x/w的高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        w.height = Math.max(x.height, height(w.left)) + 1;
        //返回新的根结点
        return w;
    }

    /**
     * 右右单旋转(RR旋转) x变为w的根结点, w变为x的左子树
     *
     * @return
     */
    private AVLNode<T> singleRotateRRToLeft(AVLNode<T> x) {
        AVLNode<T> w = x.right;
        x.right = w.left;
        w.left = x;

        //重新计算x/w的高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        w.height = Math.max(x.height, height(w.right)) + 1;

        //返回新的根结点
        return w;

    }

    /**
     * 左右旋转(LR旋转) x(根) w y 结点 把y变成根结点
     *
     * @return
     */
    private AVLNode<T> doubleRotateWithLR(AVLNode<T> x) {
        //先进行左孩子左旋转
        x.left = singleRotateRRToLeft(x.left);
        //再进行自己进行右旋转
        return singleRotateLLToRight(x);
    }

    /**
     * 右左旋转(RL旋转)
     *
     * @param x
     * @return
     */
    private AVLNode<T> doubleRotateRL(AVLNode<T> x) {
        //先对右孩子进行右旋转
        x.right = singleRotateLLToRight(x.right);
        //再对自己进行左旋转
        return singleRotateRRToLeft(x);
    }


    /**
     * 测试
     *
     * @param arg
     */
    public static void main(String arg[]) {
//
//        AVLTree.AVLTree<Integer> avlTree=new AVLTree.AVLTree<>();
//
//        for (int i = 1; i <18 ; i++) {
//            avlTree.insert(i);
//        }
//
//        avlTree.printTree(avlTree.root);
//        //删除11,8以触发旋转平衡操作
//        avlTree.remove(11);
//        avlTree.remove(8);
//
//        System.out.println("================");
//
//        avlTree.printTree(avlTree.root);
//
//        System.out.println("findMin:"+avlTree.findMin());
//
//        System.out.println("findMax:"+avlTree.findMax());
//
//        System.out.println("15 exist or not : " + avlTree.contains(15) );
//
//        System.out.println("先根遍历:"+avlTree.preOrder());
//
//        System.out.println("中根遍历:"+avlTree.inOrder());
//
//        System.out.println("后根遍历:"+avlTree.postOrder());

    }

}
