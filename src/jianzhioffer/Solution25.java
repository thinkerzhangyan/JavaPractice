package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 复杂链表的复制
 */
public class Solution25 {
    public RandomListNode Clone(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode headNode = new RandomListNode(head.label);
        RandomListNode tmpNode = headNode;

        while (head != null) {
            if (head.next != null) {
                tmpNode.next = new RandomListNode(head.next.label);
            }
            if (head.random != null) {
                tmpNode.random = new RandomListNode(head.random.label);
            }
            tmpNode = tmpNode.next;
            head = head.next;
        }

        return headNode;

    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}