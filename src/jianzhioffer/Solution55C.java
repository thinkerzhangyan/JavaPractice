package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/8/12
 * @des 判断链表是否相交，相交的话求它们的相交的结点
 */
public class Solution55C {

    //https://blog.csdn.net/jiary5201314/article/details/50990349
    public boolean isCrossedA(ListNode pHeadOne, ListNode pHeadTwo) {

        if (pHeadOne == null || pHeadTwo == null) {
            return false;
        }

        if (pHeadOne == pHeadTwo) {
            return true;
        }

        ListNode nodeTmp = pHeadTwo;
        while (pHeadOne != null) {
            while (nodeTmp != null) {
                if (pHeadOne == nodeTmp) {
                    return true;
                } else {
                    nodeTmp = nodeTmp.next;
                }
            }
            nodeTmp = pHeadTwo;
            pHeadOne = pHeadOne.next;
        }
        return false;
    }



}
