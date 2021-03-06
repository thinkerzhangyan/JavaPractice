package leetcode.list;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 链表是否有环
 */
public class HasCircle {

    public boolean isHaveLoop(ListNode pHead) {

        if (pHead == null) {
            return false;
        }

        ListNode nodeFront = pHead;
        ListNode nodeBehind = pHead;

        while (nodeFront != null) {

            nodeFront = nodeFront.next;
            if (nodeFront != null) {
                nodeFront = nodeFront.next;
            } else {
                return false;
            }

            nodeBehind = nodeBehind.next;

            if(nodeBehind==nodeFront)
                return true;

        }

        return false;
    }

}
