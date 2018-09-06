package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution15CC {

    public int getCountOfLoopNode(ListNode pHead) {

        if (pHead == null) {
            return 0;
        }

        ListNode nodeFront = pHead;
        ListNode nodeBehind = pHead;

        while (nodeFront != null) {

            nodeFront = nodeFront.next;
            if (nodeFront != null) {
                nodeFront = nodeFront.next;
            } else {
                return 0;
            }
            nodeBehind = nodeBehind.next;
            if (nodeBehind == nodeFront) {
                int countOfLoopNode = 1;
                nodeFront = nodeFront.next;
                while (nodeFront != nodeBehind) {
                    nodeFront = nodeFront.next;
                }
                return countOfLoopNode;
            }

        }


        return 0;
    }

}
