package jianzhioffer;

import java.util.LinkedList;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution14B {

    public ListNode printTheKthNodeToTailA(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        ListNode nodeBehind = head;
        ListNode nodeFront = head;

        while (k > 0) {
            if (nodeFront == null) {
                return null;
            }
            nodeFront = nodeFront.next;
            k--;
        }

        while (nodeFront != null) {
            nodeFront = nodeFront.next;
            nodeBehind = nodeBehind.next;
        }

        return nodeBehind;

    }

    public ListNode FindKthToTailB(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        LinkedList<ListNode> stack = new LinkedList<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode nodeResult = null;

        while (k > 0) {

            if (stack.size() > 0) {
                nodeResult = stack.pop();
                k--;
            } else {
                return null;
            }
        }

        return nodeResult;
    }

}
