package binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {

    //树节点
    private class BinaryTreeNode{

        String data;

        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;


        public BinaryTreeNode(String data,BinaryTreeNode leftChild,BinaryTreeNode righjtChild){

            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = righjtChild;
        }

        public BinaryTreeNode(String data){
            this(data,null,null);
        }

    }

    //根节点
    private BinaryTreeNode root;

    public BinaryTree(){
        root = null;
    }

    //构造一颗二叉树
    public void createBinaryTree(){


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

        root.rightChild.rightChild=f;

    }


    private void myprint(String str){
        System.out.println(str);
    }


    //前序遍历递归实现
    public void preOrder(BinaryTreeNode node){

        if(node!=null){

            System.out.println(node.data);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }

    }

    //中序遍历递归实现
    public void inOrder(BinaryTreeNode node){

        if(node!=null){

            inOrder(node.leftChild);
            System.out.println(node.data);
            inOrder(node.rightChild);
        }

    }


    //后序遍历递归实现
    public void postOrder(BinaryTreeNode node){

        if(node!=null){

            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.data);
        }

    }


    //前序遍历非递归实现
    public void nonRePreOrder(BinaryTreeNode node){

        if(node!=null){
            Stack<BinaryTreeNode> stack = new Stack<>();
            stack.push(node);

            while(!stack.isEmpty()){

                node = stack.pop();
                System.out.println(node.data);

                if(node.rightChild!=null)
                    stack.push(node.rightChild);
                if(node.leftChild!=null)
                    stack.push(node.leftChild);

            }


        }




    }

    //中序遍历非递归实现
    public void nonReInOrder(BinaryTreeNode node){

        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode p = node;

        while(p!=null||stack.size()>0){

            while(p!=null){
                stack.push(p);
                p=p.leftChild;
            }

            if(stack.size()>0){
                p=stack.pop();
                System.out.println(p.data);
                p=p.rightChild;
            }

        }


    }

    //后序遍历非递归实现
    public void nonRePostOrder(BinaryTreeNode node){

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = node;

        while(node!=null){
            //左子树入栈
            for(;node.leftChild!=null;node=node.leftChild){
                stack.push(node);
            }

            //没有右子树或者右子树已经被处理了
            while(node!=null&&((node.rightChild==null)||(node.rightChild==p))){

                myprint(node.data);
                p=node;
                if(stack.isEmpty())
                    return;

                node=stack.pop();

            }
            //处理右子树
            stack.push(node);
            node=node.rightChild;

        }


    }


    //只打印二叉树某层的节点，第一层是0层,节点值不返回，直接打印
    public  boolean printNodeAtLevelOne(BinaryTreeNode root,int level){

        if(root==null||level<0)
            return false;

        if(level==0){
            myprint(root.data+"");
            return true;
        }

        boolean left = printNodeAtLevelOne(root.leftChild,level-1);
        boolean right = printNodeAtLevelOne(root.rightChild,level-1);

        return left||right;
    }

    //只打印二叉树某层的节点，第一层是0层，节点值存储在list中，返回
    public boolean printNodeAtLevelTwo(BinaryTreeNode root, int level, List<String> list) {
        if (root == null || level < 0) {
            return false;
        }
        if (level == 0) {
            list.add(root.data);
            return true;
        }
        boolean left = printNodeAtLevelTwo(root.leftChild, level-1, list);
        boolean rigth = printNodeAtLevelTwo(root.rightChild, level-1, list);
        return left || rigth;
    }

    //树的层序遍历  递归实现  节点值不返回，直接打印。见编程之美 分层遍历二叉树
    public void levelOrderOne(BinaryTreeNode root) {

        if(root == null)
            return ;

        for(int level = 0; ; level++) {

            if (!printNodeAtLevelOne(root, level))
                break;

        }

    }


    //树的层序遍历  递归实现  节点值存储在List中，返回。见编程之美 分层遍历二叉树
    public List<List<String>> levelOrderTwo(BinaryTreeNode root) {

        List<List<String>> lists = new ArrayList<List<String>>();

        if (root == null)
            return lists;

        for (int level = 0; ; level++) {

            List<String> list = new ArrayList<>();

            if (!printNodeAtLevelTwo(root, level, list))
                break;

            lists.add(0, list);
        }

        return lists;
    }

    //树的层序遍历  递归实现  节点值存储在List中，返回。见剑指offer。
    public ArrayList<String> levelOrderThree(BinaryTreeNode root){

        ArrayList<String> list = new ArrayList<>();

        if(root==null)
            return list;

        for(int level=0;;level++){

            if(!printNodeAtLevelTwo(root,level,list))
                break;

        }


        return list;
    }



    //树的层序遍历  非递归实现  见牛客网 剑指offer 从上往下打印二叉树
    public void nonRelevelOrder(BinaryTreeNode node){

        if(node==null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()){

            BinaryTreeNode nodeTmp = queue.poll();
            System.out.println(nodeTmp.data);

            if(nodeTmp.leftChild!=null)
                queue.add(nodeTmp.leftChild);

            if(nodeTmp.rightChild!=null)
                queue.add(nodeTmp.rightChild);


        }


    }



    public static void main(String[]args){

        BinaryTree binaryTree = new BinaryTree();
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
        System.out.println(lists.get(2));
        System.out.println(lists.get(1));
        System.out.println(lists.get(0));

        System.out.println("nonpre");//(前序遍历)[ABDECF]
        binaryTree.nonRePreOrder(binaryTree.root);

        System.out.println("nonin");//(中序遍历)[DBEACF]
        binaryTree.nonReInOrder(binaryTree.root);

        System.out.println("nonpost");//(后序遍历)[DEBFCA]
        binaryTree.nonRePostOrder(binaryTree.root);

        System.out.println("nonlevel");//(层序遍历)[ABCDEF]
        binaryTree.nonRelevelOrder(binaryTree.root);


        System.out.println("printNodeAtLevelOne");
        binaryTree.printNodeAtLevelOne(binaryTree.root,2);//(遍历某一层)[ABCDEF]
        System.out.println("printNodeAtLevelTwo");
        List<String> list = new ArrayList<>();
        binaryTree.printNodeAtLevelTwo(binaryTree.root,2,list);//(遍历某一层)[ABCDEF]
        System.out.println(list);


    }



}
