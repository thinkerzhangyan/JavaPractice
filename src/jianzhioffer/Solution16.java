package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/12/7
 * @des 合并排序的链表
 */
public class Solution16 {
    public ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode nodeMerge = null;

        if (list1.val < list2.val) {
            nodeMerge = list1;
            nodeMerge.next = Merge(list1.next, list2);
        }
        else {
            nodeMerge = list2;
            nodeMerge.next = Merge(list1, list2.next);
        }

        return nodeMerge;
    }
}
