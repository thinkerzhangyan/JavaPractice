package leetcode.list;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 删除链表中的重复的结点,重复嫩肤
 */
public class DeleteSortListDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode nodeHead = pHead;
        ListNode nodeTmp = nodeHead;
        while (nodeTmp != null) {
            ListNode nodeNext = nodeTmp.next;
            while (nodeNext != null && nodeTmp.val == nodeNext.val) {
                nodeNext = nodeNext.next;
            }
            nodeTmp.next = nodeNext;
            nodeTmp = nodeNext;
        }
        return nodeHead;
    }

    public ListNode deleteDuplicationB(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nodeHead = head;
        ListNode nodeTmp = nodeHead;
        while (nodeTmp != null) {
            ListNode nodeNext = nodeTmp.next;
            while (nodeNext != null && nodeNext.val == nodeTmp.val) {
                nodeNext = nodeNext.next;
            }
            nodeTmp.next = nodeNext;
            nodeTmp = nodeNext;
        }
        return nodeHead;
    }
}
