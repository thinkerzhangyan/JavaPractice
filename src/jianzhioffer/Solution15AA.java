package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution15AA {

    public static ListNode reverse(ListNode root) {

        if (root == null) {
            return null;
        }

        ListNode nodeHead = null;
        ListNode nodePre = null;
        ListNode nodeNow = root;

        while (nodeNow != null) {
            ListNode nodeNext = nodeNow.next;
            if (nodeNext == null) {
                nodeHead = nodeNow;
            }
            nodeNow.next = nodePre;
            nodePre = nodeNow;
            nodeNow = nodeNext;
        }

        return nodeHead;
    }

    public static void main(String[] args) {

        ListNode nodeOne = new ListNode(1);

        ListNode nodeTwo = new ListNode(2);
        nodeOne.next = nodeTwo;

        ListNode nodeThree = new ListNode(3);
        nodeTwo.next = nodeThree;

        ListNode nodeFour = new ListNode(4);
        nodeThree.next = nodeFour;


        ListNode nodeFive = new ListNode(5);
        nodeFour.next = nodeFive;

        ListNode nodeHead = reverse(nodeOne);

        while (nodeHead != null) {
            System.out.println(nodeHead.val);
            nodeHead = nodeHead.next;
        }
    }

}
