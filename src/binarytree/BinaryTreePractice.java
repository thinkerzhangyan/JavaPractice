package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by macbook on 2017/10/12.
 */
public class BinaryTreePractice {

    private class BinaryTreeNode {

        private String data;

        private BinaryTreeNode leftChild;
        private BinaryTreeNode rightChild;

        public BinaryTreeNode(String data, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public BinaryTreeNode(String data) {
            this(data, null, null);
        }
    }


    private BinaryTreeNode root;

    public BinaryTreePractice() {
        this.root = null;
    }


    public void createBinaryTree() {

        BinaryTreeNode a = new BinaryTreeNode("A");
        BinaryTreeNode b = new BinaryTreeNode("B");
        BinaryTreeNode c = new BinaryTreeNode("C");
        BinaryTreeNode d = new BinaryTreeNode("D");
        BinaryTreeNode e = new BinaryTreeNode("E");
        BinaryTreeNode f = new BinaryTreeNode("F");


        root = a;

        root.leftChild = b;
        root.rightChild = c;

        root.leftChild.leftChild = d;
        root.leftChild.rightChild = e;

        root.rightChild.rightChild = f;

    }


    private void myprint(String data) {
        System.out.println(data);
    }


    private void preOrder(BinaryTreeNode root) {
        if (root != null) {
            myprint(root.data);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    private void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.leftChild);
            myprint(root.data);
            inOrder(root.rightChild);
        }
    }

    private void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            myprint(root.data);
        }
    }


    private boolean printNodeAtLevelOne(BinaryTreeNode root, int level) {

        if (root == null || level < 0) {
            return false;
        }

        if (level == 0) {
            myprint(root.data);
            return true;
        }

        boolean left = printNodeAtLevelOne(root.leftChild, level - 1);
        boolean right = printNodeAtLevelOne(root.rightChild, level - 1);

        return left || right;

    }


    private void levelOrderOne(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        for (int level = 0; ; level++) {
            if (!printNodeAtLevelOne(root, level)) {
                return;
            }
        }

    }

    private boolean printNodeAtLevelTwo(BinaryTreeNode root, int level, List<String> list) {

        if (root == null || level < 0) {
            return false;
        }

        if (level == 0) {
            list.add(root.data);
            return true;
        }

        boolean left = printNodeAtLevelTwo(root.leftChild, level - 1, list);
        boolean right = printNodeAtLevelTwo(root.rightChild, level - 1, list);

        return left || right;

    }


    private List<List<String>> levelOrderTwo(BinaryTreeNode root) {

        List<List<String>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        for (int level = 0; ; level++) {
            List<String> list = new ArrayList<>();
            if (!printNodeAtLevelTwo(root, level, list)) {
                return lists;
            }
            lists.add(list);
        }

    }


    private void nonRePreOrder(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        LinkedList<BinaryTreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (stack.size() > 0) {

            root = stack.pop();
            myprint(root.data);
            if (root.rightChild != null) {
                stack.push(root.rightChild);
            }
            if (root.leftChild != null) {
                stack.push(root.leftChild);
            }
        }

    }


    private void nonReInOrder(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        LinkedList<BinaryTreeNode> stack = new LinkedList<>();

        BinaryTreeNode p = root;

        while (stack.size() > 0 || p != null) {

            while (p != null) {
                stack.push(p);
                p = p.leftChild;
            }

            if (stack.size() > 0) {
                root = stack.pop();
                myprint(root.data);
                p = root.rightChild;
            }

        }

    }


    private void nonRePostOrder(BinaryTreeNode root) {

        if (root == null) {
            return;
        }

        LinkedList<BinaryTreeNode> stack = new LinkedList<>();

        BinaryTreeNode p = root;

        while (root != null) {

            for (; root.leftChild != null; root = root.leftChild) {
                stack.push(root);
            }

            while (root != null && ((root.rightChild == null) || (root.rightChild == p))) {

                myprint(root.data);
                p = root;
                if (stack.size() == 0) {
                    return;
                }
                root = stack.pop();
            }

            stack.push(root);
            root = root.rightChild;

        }
    }


    private void nonReLevelOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0) {

            root = queue.poll();
            myprint(root.data);
            if (root.leftChild != null) {
                queue.add(root.leftChild);
            }
            if (root.rightChild != null) {
                queue.add(root.rightChild);
            }
        }

    }

    public static void main(String[] args) {

        BinaryTreePractice binaryTree = new BinaryTreePractice();
        binaryTree.createBinaryTree();

        System.out.println("pre");
        binaryTree.preOrder(binaryTree.root);//(前序遍历)[ABDECF]

        System.out.println("in");
        binaryTree.inOrder(binaryTree.root);//(中序遍历)[DBEACF]

        System.out.println("post");
        binaryTree.postOrder(binaryTree.root);//(后序遍历)[DEBFCA]

        System.out.println("levelOne");
        binaryTree.levelOrderOne(binaryTree.root);//(层序遍历)[ABCDEF]

        System.out.println("levelTwo");
        List<List<String>> lists = binaryTree.levelOrderTwo(binaryTree.root);//(层序遍历)[ABCDEF]
        for (List<String> list : lists) {
            System.out.println(list);
        }

        System.out.println("nonpre");//(前序遍历)[ABDECF]
        binaryTree.nonRePreOrder(binaryTree.root);

        System.out.println("nonin");//(中序遍历)[DBEACF]
        binaryTree.nonReInOrder(binaryTree.root);

        System.out.println("nonpost");//(后序遍历)[DEBFCA]
        binaryTree.nonRePostOrder(binaryTree.root);

        System.out.println("nonlevel");//(层序遍历)[ABCDEF]
        binaryTree.nonReLevelOrder(binaryTree.root);

        System.out.println("printNodeAtLevelOne");
        binaryTree.printNodeAtLevelOne(binaryTree.root, 2);//(遍历某一层)[ABCDEF]
        System.out.println("printNodeAtLevelTwo");
        List<String> list = new ArrayList<>();
        binaryTree.printNodeAtLevelTwo(binaryTree.root, 2, list);//(遍历某一层)[ABCDEF]
        System.out.println(list);

    }


}
