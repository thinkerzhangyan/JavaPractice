package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/8/12
 * @des
 */
public class Solution25B {

    public RandomListNodeB Clone(RandomListNodeB head) {

        if (head == null) {
            return head;
        }

        RandomListNodeB headClone = new RandomListNodeB(head.label);


        RandomListNodeB nodeNext = headClone.next;

        while (head.next != null) {
            head = head.next;
            nodeNext.next = new RandomListNodeB(head.next.label);
            nodeNext.random = new RandomListNodeB(head.next.random.label);
            nodeNext = nodeNext.next;
        }

        return headClone;

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
