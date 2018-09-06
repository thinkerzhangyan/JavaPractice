package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution16B {

    public ListNode mergeList(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode nodeHead;

        if (list1.val < list2.val) {
            nodeHead = list1;
            nodeHead.next = mergeList(list1.next, list2);
        } else {
            nodeHead = list2;
            nodeHead.next = mergeList(list1, list2.next);
        }

        return nodeHead;
    }

}
