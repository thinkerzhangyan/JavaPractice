package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution3B {

    public ArrayList<Integer> printListFromTailToHeadA(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (stack.size() != 0) {
            list.add(stack.pop().val);
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHeadB(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHeadC(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        list = printListFromTailToHeadC(listNode.next);

        list.add(listNode.val);

        return list;

    }


}
