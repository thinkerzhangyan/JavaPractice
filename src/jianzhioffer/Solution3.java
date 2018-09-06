package jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 从尾部到头部打印二叉树
 */
public class Solution3 {

    public ArrayList<Integer> printListFromTailToHeadA(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();

        if(listNode==null)
            return list;

        ListNode temp = listNode;

        while(temp!=null){
            list.add(0,temp.val);
            temp=temp.next;
        }


        return list;
    }

    //链表比较长的时候，导致函数调用栈比较深，可能会导致调用栈溢出。
    public ArrayList<Integer> printListFromTailToHeadB(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();

        if(listNode==null)
            return list;

        list = printListFromTailToHeadB(listNode.next);

        list.add(listNode.val);


        return list;
    }

    public ArrayList<Integer> printListFromTailToHeadC(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();

        if(listNode==null)
            return list;

        Stack<Integer> stack = new Stack<>();

        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }

        while (!stack.empty()) {
            list.add(stack.pop());
        }


        return list;
    }


    public ArrayList<Integer> printListFromTailToHeadD(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();

        if (listNode == null) {
            return list;
        }

        if (listNode.next == null) {
            list.add(listNode.val);
            return list;
        }

        list = printListFromTailToHeadD(listNode.next);

        list.add(listNode.val);

        return list;
    }



    public static void main(String[] args) {

        ListNode nodeHead = new ListNode(0);
        nodeHead.next = new ListNode(1);

        ListNode nodeTmp = nodeHead.next;

        int i = 2;

        while (i < 10) {
            nodeTmp.next = new ListNode(i);
            nodeTmp = nodeTmp.next;
            i++;
        }


        Solution3 solution3 = new Solution3();

        List<Integer> list = solution3.printListFromTailToHeadC(nodeHead);

        System.out.println(list);

    }

}

class ListNode {

    int val=0;
    ListNode next=null;

    public ListNode(int val) {
        this.val = val;
    }
}
