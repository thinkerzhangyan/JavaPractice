package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 删除链表中的重复的结点
 */
public class Solution56 {
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode nodeNew = new ListNode(0);
        nodeNew.next = pHead;

        ListNode nodePre = nodeNew;
        ListNode nodeCur = pHead;

        while (nodeCur != null) {

            while (nodeCur.next != null && nodeCur.val == nodeCur.next.val) {
                nodeCur = nodeCur.next;
            }

            if (nodePre.next == nodeCur) {
                nodePre = nodeCur;
            } else {
                nodePre.next = nodeCur.next;
            }

            nodeCur = nodeCur.next;
        }

        return nodeNew.next;
    }

    public ListNode deleteDuplicationB(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;

        ListNode nodePre = nodeHead;
        ListNode nodeCur = head;
        while (nodeCur != null) {
            while (nodeCur.next != null && nodeCur.next.val == nodeCur.val) {
                nodeCur = nodeCur.next;
            }
            if (nodePre.next == nodeCur) {
                nodePre = nodeCur;
            } else {
                nodePre.next = nodeCur.next;
            }
            nodeCur = nodeCur.next;
        }
        return nodeHead.next;
    }
}
