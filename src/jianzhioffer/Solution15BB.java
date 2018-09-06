package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution15BB {

    public boolean isContainLoop(ListNode pHead) {

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
            if (nodeFront == nodeBehind) {
                return true;
            }
        }

        return false;

    }

}
