package jianzhioffer;

import java.util.AbstractCollection;
import java.util.ArrayList;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution41B {

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (sum < 3) {
            return lists;
        }

        int head = 1;
        int tail = 2;

        int middle = (sum + 1) >> 1;

        int curSum = head + tail;

        while (head < middle) {

            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=head;i<=tail;i++) {
                    list.add(i);
                }
                lists.add(list);
            }

            while (curSum > sum && head < middle) {
                curSum -= head;
                head++;
                if (curSum == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i=head;i<=tail;i++) {
                        list.add(i);
                    }
                    lists.add(list);
                }
            }

            tail++;
            curSum += tail;
        }

        return lists;

    }

}
