package jianzhioffer;

import java.util.ArrayList;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 和为S的连续正数序列
 */
public class Solution41 {
    public ArrayList<ArrayList<Integer>> findContinusSequence(int sum) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if(sum<3)
            return lists;

        int front = 1;
        int behind = 2;

        int middle = (sum + 1) >> 1;

        int curSum = front + behind;

        while (front < middle) {

            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=front;i<=behind;i++) {
                    list.add(i);
                }
                lists.add(list);
            }

            while (curSum > sum && front < middle) {
                curSum -= front;
                front++;
                if (curSum == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i=front;i<=behind;i++) {
                        list.add(i);
                    }
                    lists.add(list);
                }
            }

            behind++;
            curSum += behind;

        }

        return lists;
    }

}
