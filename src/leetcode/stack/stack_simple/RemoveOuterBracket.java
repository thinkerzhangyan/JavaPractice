package leetcode.stack.stack_simple;

import java.util.LinkedList;

public class RemoveOuterBracket {
    public String solve(String S) {
        if (S == null) {
            return "";
        }

        int start = 0;
        int end = 0;

        LinkedList<Character> stack = new LinkedList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < S.length();index++) {
            char chTmp = S.charAt(index);

            if (chTmp == '(') {
                if (stack.isEmpty()) {
                    start = index;
                }
                stack.push(chTmp);
            }

            if (chTmp == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    end = index;
                    stringBuilder.append(S.substring(start + 1, end));
                }
            }
        }

        return stringBuilder.toString();
    }
}
