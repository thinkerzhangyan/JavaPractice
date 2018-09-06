/**
 * @author zhangyan
 * @date 2018/8/12
 * @des
 */
public class Solution25 {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        RandomListNode nodeHead = new RandomListNode(pHead.label);

        RandomListNode nodeTemp  = nodeHead;

        while (pHead!= null) {
            if (pHead.next != null) {
                nodeTemp.next = new RandomListNode(pHead.next.label);
            }
            if (pHead.random != null) {
                nodeTemp.random = new RandomListNode(pHead.random.label);
            }
            pHead = pHead.next;
            nodeTemp = nodeTemp.next;
        }

        return nodeHead;
    }


}

class RandomListNode {

    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int label) {
        this.label = label;
    }
}
