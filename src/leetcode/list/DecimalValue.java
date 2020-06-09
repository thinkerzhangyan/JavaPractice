package leetcode.list;

/**
 * @author zhangyan
 * @date 2020/5/26
 * @des  给你一个单链表的引用结点head。链表中每个结点的值不是0就是1。已知此链表是一个整数数字的二进制表示形式。请你返回该链表所表示数字的十进制值。
 */
public class DecimalValue {

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int sum = 0;
        int countOfNode = 0;

        ListNode nodeTmp = head;
        while (nodeTmp != null) {
            countOfNode++;
            nodeTmp = nodeTmp.next;
        }
        nodeTmp = head;
        int index = countOfNode;
        while (nodeTmp != null) {
            if (nodeTmp.val == 1) {
                sum += (1 << (index-1));
            }
            --index;
            nodeTmp = nodeTmp.next;
        }
        return sum;
    }

}
