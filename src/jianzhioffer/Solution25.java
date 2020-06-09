package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 复杂链表的复制
 */
public class Solution25 {

    /*
    * 题目解析：https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba?answerType=1&f=discussion
    */
    public RandomListNode CloneA(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newHead = null;
        RandomListNode originNode = head;
        RandomListNode newNode = null;
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        while (originNode != null) {
            if (newHead == null) {
                newHead = new RandomListNode(originNode.label);
                newNode = newHead;
                hashMap.put(originNode, newHead);
            } else {
                if (originNode.next != null && hashMap.containsKey(originNode.next)) {
                    newNode.next = hashMap.get(originNode.next);
                } else {
                    if (originNode.next != null) {
                        RandomListNode tmpNode = new RandomListNode(originNode.next.label);
                        newNode.next = tmpNode;
                        hashMap.put(originNode.next, tmpNode);
                    }
                }
                if (originNode.random != null && hashMap.containsKey(originNode.random)) {
                    newNode.random = hashMap.get(originNode.random);
                } else {
                    if (originNode.random != null) {
                        RandomListNode tmpNode = new RandomListNode(originNode.random.label);
                        newNode.random = tmpNode;
                        hashMap.put(originNode.random, tmpNode);
                    }
                }
                originNode = originNode.next;
                newNode = newNode.next;
            }
        }
        return newHead;
    }

    public RandomListNode cloneB(RandomListNode head) {
        if (head == null) {
            return head;
        }
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        RandomListNode curNode = head;
        while (curNode != null) {
            RandomListNode tmpNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            curNode.next = tmpNode;
            tmpNode.next = nextNode;
            curNode = nextNode;
        }
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        curNode = head;
        while (curNode != null) {
            curNode.next.random = curNode.random == null ? null : curNode.random.next;
            curNode = curNode.next.next;
        }
        //3、拆分链表，将链表拆分为原链表和复制后的链表
        curNode = head;
        RandomListNode cloneNode = curNode.next;
        while (curNode != null) {
            RandomListNode tmpNode = curNode.next;
            curNode.next = tmpNode.next;
            tmpNode.next = tmpNode.next == null ? null : tmpNode.next.next;
            curNode = curNode.next;
        }
        return cloneNode;
    }

    public RandomListNode clone(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode curNode = head;
        while (curNode != null) {
            RandomListNode tmpNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            curNode.next = tmpNode;
            tmpNode.next = nextNode;
            curNode = nextNode;
        }
        curNode = head;
        while (curNode != null) {
            curNode.next.random = curNode.random == null ? null : curNode.random.next;
            curNode = curNode.next.next;
        }
        curNode = head;
        RandomListNode newHead = curNode.next;
        while (curNode != null) {
            RandomListNode tmpNode = curNode.next;
            curNode.next = tmpNode.next;
            tmpNode.next = tmpNode.next == null ? null : tmpNode.next.next;
            curNode = curNode.next;
        }
        return newHead;
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