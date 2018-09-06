package jianzhioffer;

import java.util.*;

/**
 * @author zhangyan
 * @date 2017/12/7
 * @des 反转链表
 */
public class Solution15A {
    public static ListNode reverseList(ListNode head) {


        ListNode nodeHead = null;

        ListNode nodePre = null;

        ListNode nodeNow = head;


        while (nodeNow != null) {

            ListNode nodeNext = nodeNow.next;

            if (nodeNext == null) {
                nodeHead = nodeNow;
            }

            nodeNow.next = nodePre;
            nodePre = nodeNow;
            nodeNow = nodeNext;

        }

        return nodeHead;
    }

    public static void main(String[] args) {

        ListNode nodeOne = new ListNode(1);

        ListNode nodeTwo = new ListNode(2);
        nodeOne.next = nodeTwo;

        ListNode nodeThree = new ListNode(3);
        nodeTwo.next = nodeThree;

        ListNode nodeFour = new ListNode(4);
        nodeThree.next = nodeFour;


        ListNode nodeFive = new ListNode(5);
        nodeFour.next = nodeFive;

        ListNode nodeHead = reverseList(nodeOne);

        while (nodeHead != null) {
            System.out.println(nodeHead.val);
            nodeHead = nodeHead.next;
        }
    }
}
