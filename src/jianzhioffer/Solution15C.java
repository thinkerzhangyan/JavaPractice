package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 计算链表中环的结点数量
 */
public class Solution15C {

    public int nodeCountOfLoop(ListNode pHead)
    {
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
                int countOfNode = 1;
                nodeFront = nodeFront.next;
                while (nodeFront != nodeBehind) {
                    nodeFront = nodeFront.next;
                    countOfNode++;
                }
                return countOfNode;
            }
        }

        return 0;
    }

}


