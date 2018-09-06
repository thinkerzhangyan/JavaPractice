package jianzhioffer;

import com.sun.tools.javac.util.List;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution36B {


    public ListNode findFirstCommondNodeA(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        if (pHead1 == pHead2) {
            return pHead1;
        }

        int lengthOfOne = 0;
        ListNode nodeOne = pHead1;
        while (nodeOne != null) {
            lengthOfOne++;
            nodeOne = nodeOne.next;
        }

        int lengthOfTwo = 0;
        ListNode nodeTwo = pHead2;
        while (nodeTwo != null) {
            lengthOfTwo++;
            nodeTwo = nodeTwo.next;
        }

        nodeOne = pHead1;
        nodeTwo = pHead2;

        int len = lengthOfOne - lengthOfTwo;

        if (len > 0) {

            while (len != 0) {
                nodeOne = nodeOne.next;
                len--;
            }

        } else {
            while (len != 0) {
                nodeTwo = nodeTwo.next;
                len--;
            }
        }


        while (nodeOne != nodeTwo) {
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next;
        }

        return nodeOne;

    }

    public ListNode findFirstCommondNodeB(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        if (pHead1 == pHead2) {
            return pHead1;
        }

        LinkedList<ListNode> stackOne = new LinkedList<>();
        LinkedList<ListNode> stackTwo = new LinkedList<>();

        while (pHead1 != null) {
            stackOne.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stackTwo.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode nodeCommond = null;

        while (stackOne.peek() == stackTwo.peek()) {
            if (stackOne.size() == 0 || stackTwo.size() == 0) {
                return nodeCommond;
            }
            nodeCommond = stackOne.pop();
            stackTwo.pop();

        }

        return nodeCommond;
    }

}
