package jianzhioffer;

import java.util.LinkedList;

/**
 * @author zhangyan
 * @date 2017/12/7
 * @des 链表中倒数第K个结点
 */
public class Solution14 {


    public ListNode FindKthToTailA(ListNode head, int k) {

        if (head == null || k == 0) {
            return null;
        }

        ListNode nodeFront = head;
        ListNode nodeBehind = head;

        while ((k - 1) != 0) {
            k--;
            nodeFront = nodeFront.next;
            if (nodeFront == null) {
                return null;
            }
        }

        while (nodeFront.next != null) {

            nodeBehind = nodeBehind.next;
            nodeFront = nodeFront.next;

        }

        return nodeBehind;

    }


    public ListNode FindKthToTailB(ListNode head, int k) {

        if (head == null || k == 0) {
            return null;
        }

        LinkedList<ListNode> stack = new LinkedList<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode nodeResult = null;

        while (k > 0) {
            if (stack.size() != 0) {
                nodeResult = stack.pop();
                k--;
            } else {
                return null;
            }
        }

        return nodeResult;

    }


}
