package jianzhioffer;

import java.util.LinkedList;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution14B {

    public ListNode printTheKthNodeToTailA(ListNode head, int k) {

        if (head == null || k == 0)
            return null;

        ListNode nodeHead = head;
        ListNode nodeBehind = head;

        while (k - 1 != 0) {
            nodeHead = nodeHead.next;
            k--;
            if (nodeHead == null) {
                return null;
            }
        }


        while (nodeHead.next != null) {
            nodeHead = nodeHead.next;
            nodeBehind = nodeBehind.next;
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

        ListNode nodeKth = null;

        while (k != 0) {
            if (stack.size() != 0) {
                nodeKth = stack.poll();
                k--;
            } else {
                return null;
            }
        }

        return nodeKth;
    }

}
