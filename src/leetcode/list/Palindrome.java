package leetcode.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyan
 * @date 2020/4/29
 * @des 请判断一个链表是否为回文链表。
 */
public class Palindrome {


    public static void main(String[] args) {
        System.out.println("result:" + 7 / 2);
    }

    //时间复杂度和空间复杂度都为O(n)
    public boolean isPalindromeA(ListNode listNode) {
        if (listNode == null) {
            return true;
        }

        boolean result = true;

        List<Integer> list = new ArrayList<>();

        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        int head = 0;
        int end = list.size() - 1;

        while (head < end) {
            if (!list.get(head).equals(list.get(end))) {
                return false;
            } else {
                head++;
                end--;
            }
        }

        return result;
    }


    //时间复杂度为O(n),空间复杂度为O(n)
    public boolean isPalindromeB(ListNode listNode) {
        if (listNode == null) {
            return true;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        int count = 0;

        ListNode nodeTmp = listNode;
        while (nodeTmp != null) {
            count++;
            nodeTmp = nodeTmp.next;
        }
        nodeTmp = listNode;

        if (count == 1) {
            return true;
        }

        boolean isOdd = count % 2 != 0;

        int times = count / 2;

        if (isOdd) {
            while (nodeTmp != null && times > 0) {
                times--;
                stack.push(nodeTmp.val);
                nodeTmp = nodeTmp.next;
            }
            nodeTmp = nodeTmp.next;
            while (!stack.isEmpty() && nodeTmp != null) {
                if (stack.peek() == nodeTmp.val) {
                    nodeTmp = nodeTmp.next;
                    stack.poll();
                } else {
                    return false;
                }
            }
        } else {
            while (nodeTmp != null && times > 0) {
                times--;
                stack.push(nodeTmp.val);
                nodeTmp = nodeTmp.next;
            }
            while (!stack.isEmpty() && nodeTmp != null) {
                if (stack.peek() == nodeTmp.val) {
                    nodeTmp = nodeTmp.next;
                    stack.poll();
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    //时间复杂度为O(n),空间复杂度为O(1)
    public boolean isPalindromeC(ListNode listNode) {
        if (listNode == null) {
            return true;
        }
        ListNode nodeTmp = frontHalfEnd(listNode);
        nodeTmp = reverseList(nodeTmp.next);

        ListNode nodeBehind = listNode;
        ListNode nodeFront = nodeTmp;

        while (nodeBehind != null && nodeFront != null) {
            if (nodeBehind.val == nodeFront.val) {
                nodeBehind = nodeBehind.next;
                nodeFront = nodeFront.next;
            } else {
                return false;
            }
        }

        return true;
    }

    private ListNode frontHalfEnd(ListNode listNode) {
        ListNode nodeSlow = listNode;
        ListNode nodeFast = listNode;
        while (nodeFast != null && nodeFast.next != null && nodeFast.next.next != null) {
            nodeFast = nodeFast.next.next;
            nodeSlow = nodeSlow.next;
        }
        return nodeSlow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode nodePre = null;
        ListNode nodeNow = head;
        ListNode nodeHead = null;

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
}

