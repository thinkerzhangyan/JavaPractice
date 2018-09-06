package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 链表中环的入口结点
 */
public class Solution55A {
    //http://www.cppblog.com/humanchao/archive/2008/04/17/47357.html
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) {
            return null;
        }

        ListNode nodeFront = pHead;
        ListNode nodeBehind = pHead;

        while (nodeFront != null) {
            nodeFront = nodeFront.next;
            if (nodeFront != null) {
                nodeFront = nodeFront.next;
            } else {
                return null;
            }
            nodeBehind = nodeBehind.next;
            if (nodeBehind == nodeFront) {
                break;
            }
        }

        if (nodeFront == null) {
            return null;
        }

        nodeBehind = pHead;

        while (nodeBehind != nodeFront) {
            nodeFront = nodeFront.next;
            nodeBehind = nodeBehind.next;
        }


        return nodeFront;
    }
}
