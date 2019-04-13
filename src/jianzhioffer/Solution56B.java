package jianzhioffer;

import java.util.List;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution56B {

    public ListNode deleteDuplication(ListNode pHead) {


        if (pHead == null) {
            return null;
        }

        ListNode nodeNew = new ListNode(0);
        nodeNew.next = pHead;

        ListNode nodePre = nodeNew;
        ListNode nodeCur = pHead;

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

        return nodeNew.next;

    }

}