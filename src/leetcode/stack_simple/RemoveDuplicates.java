package leetcode.stack_simple;

import java.util.LinkedList;

public class RemoveDuplicates {

    public String removeDuplicates(String S) {

        if (S == null || S.length() == 0) {
            return S;
        }

        LinkedList<Character> stack = new LinkedList<>();

        char[] chars = S.toCharArray();

        int len = chars.length;

        for (int index = len - 1; index >= 0; index--) {
            char tmpChar = chars[index];
            if (!stack.isEmpty() && tmpChar == stack.peek()) {
                while (!stack.isEmpty() && tmpChar == stack.peek()) {
                    stack.pop();
                }
            } else {
                stack.push(tmpChar);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }

}
