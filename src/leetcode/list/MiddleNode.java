package leetcode.list;

/**
 * @author zhangyan
 * @date 2020/5/26
 * @des  给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nodeFast = head;
        ListNode nodeSlow = head;
        while (nodeFast != null) {
            nodeFast = nodeFast.next;
            if (nodeFast != null) {
                nodeFast = nodeFast.next;
            } else {
                return nodeSlow;
            }
            nodeSlow = nodeSlow.next;
        }
        return nodeSlow;
    }

}
