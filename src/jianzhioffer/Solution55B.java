package jianzhioffer;

import java.util.List;

/**
 * @author zhangyan
 * @date 2018/8/12
 * @des 判断链表是否相交
 */
public class Solution55B {

    //https://blog.csdn.net/jiary5201314/article/details/50990349
    //http://www.cppblog.com/humanchao/archive/2008/04/17/47357.html

    //暴力破解 直接判断第一个链表中的节点是否在第二个链表中
    public boolean isCrossedA(ListNode pHeadOne, ListNode pHeadTwo) {

        if (pHeadOne == null || pHeadTwo == null) {
            return false;
        }

        if (pHeadOne == pHeadTwo) {
            return true;
        }

        ListNode nodeTmp = pHeadTwo;
        while (pHeadOne != null) {
            while (nodeTmp != null) {
                if (pHeadOne == nodeTmp) {
                    return true;
                } else {
                    nodeTmp = nodeTmp.next;
                }
            }
            nodeTmp = pHeadTwo;
            pHeadOne = pHeadOne.next;
        }
        return false;
    }

    //将第一个链表的最后一个结点的next指针指向第二个链表的头结点，然后判断链表有环，这个方法不容易找到相交结点
    public boolean isCrossedB(ListNode pHeadOne, ListNode pHeadTwo) {

        if (pHeadOne == null || pHeadTwo == null) {
            return false;
        }

        if (pHeadOne == pHeadTwo) {
            return true;
        }

        while (pHeadOne.next != null) {
            pHeadOne = pHeadOne.next;
        }
        pHeadOne.next = pHeadTwo;

        while (pHeadTwo!= null) {
            pHeadTwo = pHeadTwo.next;
            if (pHeadTwo == pHeadOne) {
                return true;
            }
        }

        return false;
    }

    //直接比较最后一个节点是否相同
    public boolean isCrossedC(ListNode pHeadOne, ListNode pHeadTwo) {

        if (pHeadOne == null || pHeadTwo == null) {
            return false;
        }

        if (pHeadOne == pHeadTwo) {
            return true;
        }

        ListNode pEndOne = null;
        while (pHeadOne.next != null) {
            pHeadOne = pHeadOne.next;
        }
        pEndOne = pHeadOne;

        ListNode pEndTwo = null;
        while (pHeadTwo.next != null) {
            pHeadTwo = pHeadTwo.next;
        }
        pEndTwo = pHeadTwo;

        if (pEndOne == pEndTwo) {
            return true;
        }

        return false;
    }


}
