package leetcode.stack_simple;

import java.util.LinkedList;

public class CalculatePoints {

    public int solve(String[] ops) {

        if (ops == null || ops.length == 0) {
            return 0;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        for (int index = 0; index < ops.length; index++) {
            String strTmp = ops[index];

            if (strTmp.equals("C")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (strTmp.equals("D")) {
                if (!stack.isEmpty()) {
                    stack.push(stack.peek() * 2);
                }
            } else if (strTmp.equals("+")) {
                if (!stack.isEmpty()) {
                    Integer firstLast = stack.pop();
                    Integer secondLast = 0;
                    if (!stack.isEmpty()) {
                        secondLast = stack.pop();
                    }
                    stack.push(secondLast);
                    stack.push(firstLast);
                    stack.push(firstLast + secondLast);
                }
            } else {
                stack.push(Integer.parseInt(strTmp));
            }

        }

        Integer sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
