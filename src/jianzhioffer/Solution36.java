package jianzhioffer;

import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 两个链表的第一个公共结点
 */
public class Solution36 {

    public ListNode findFirstCommonNodeA(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int lengthOfListOne = 0;
        int lengthOfListTwo = 0;

        ListNode nodeOne = pHead1;
        ListNode nodeTwo = pHead2;

        while (nodeOne != null) {
            lengthOfListOne++;
            nodeOne = nodeOne.next;
        }

        while (nodeTwo != null) {
            lengthOfListTwo++;
            nodeTwo = nodeTwo.next;
        }

        int len = 0;

        if (lengthOfListOne > lengthOfListTwo) {
            len = lengthOfListOne - lengthOfListTwo;
            while (len != 0) {
                pHead1 = pHead1.next;
                len--;
            }
        } else {
            len = lengthOfListTwo - lengthOfListOne;
            while (len != 0) {
                pHead2 = pHead2.next;
                len--;
            }
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }


        return pHead1;
    }


    public ListNode findFirstCommonNodeB(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        Stack<ListNode> stackOne = new Stack<>();
        Stack<ListNode> stackTwo = new Stack<>();

        while (pHead1 != null) {
            stackOne.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stackTwo.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode nodeResult = null;

        while (stackOne.peek() == stackTwo.peek()) {
            nodeResult = stackOne.pop();
            stackTwo.pop();
            if (stackOne.size() == 0 || stackTwo.size() == 0) {
                return nodeResult;
            }
        }

        return nodeResult;
    }

}

