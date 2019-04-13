package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/8/12
 * @des
 */
public class Solution25B {

    public RandomListNodeB Clone(RandomListNodeB head) {

        if (head == null) {
            return null;
        }

        RandomListNodeB nodeHead = new RandomListNodeB(head.label);

        RandomListNodeB nodeTmp = nodeHead;

        while (head != null) {
            if (head.next != null) {
                nodeTmp.next = new RandomListNodeB(head.next.label);
            }
            if (head.random != null) {
                nodeTmp.random = new RandomListNodeB(head.random.label);
            }
            nodeTmp = nodeTmp.next;
            head = head.next;
        }


        return nodeHead;
    }

}

class RandomListNodeB {

    int label;
    RandomListNodeB next;
    RandomListNodeB random;

    public RandomListNodeB(int label) {
        this.label = label;
    }
}
