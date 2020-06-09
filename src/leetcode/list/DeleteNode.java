package leetcode.list;

/**
 * @author zhangyan
 * @date 2020/5/26
 * @des  请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 */
public class DeleteNode {

    //请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
    public void deleteNodeA(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
    public ListNode deleteNodeB(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;

        ListNode nodePre = nodeHead;
        ListNode nodeCur = nodeHead.next;
        while (nodeCur != null && nodeCur.val != val) {
            nodePre = nodeCur;
            nodeCur = nodeCur.next;
        }
        if (nodeCur != null) {
            nodePre.next = nodeCur.next;
        }

        return nodeHead.next;
    }

    //删除链表中等于给定值val的所有节点。
    public ListNode deleteNodeC(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode nodeHead = new ListNode(0);
        nodeHead.next = head;

        ListNode nodePre = nodeHead;
        ListNode nodeCur = head;
        while (nodeCur != null) {
            if (nodeCur.val == val) {
                nodePre.next = nodeCur.next;
            } else {
                nodePre = nodeCur;
            }
            nodeCur = nodeCur.next;
        }
        return nodeHead.next;
    }

}
