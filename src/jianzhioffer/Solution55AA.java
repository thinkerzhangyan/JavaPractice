package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution55AA {

    public ListNode getEntryNodeOfLoop(ListNode pHead) {

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

        while (nodeFront != nodeBehind) {
            nodeFront = nodeFront.next;
            nodeBehind = nodeBehind.next;
        }

        return nodeBehind;

    }

}
