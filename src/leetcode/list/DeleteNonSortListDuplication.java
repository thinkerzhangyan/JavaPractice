package leetcode.list;

import java.util.HashSet;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class DeleteNonSortListDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        ListNode nodeHead = pHead;
        ListNode nodeTmp = nodeHead;
        while (nodeTmp != null) {
            hashSet.add(nodeTmp.val);
            ListNode nodeNext = nodeTmp.next;
            while (nodeNext != null && (nodeTmp.val == nodeNext.val || hashSet.contains(nodeNext.val))) {
                nodeNext = nodeNext.next;
            }
            nodeTmp.next = nodeNext;
            nodeTmp = nodeNext;
        }
        return nodeHead;
    }


}
