package leetcode.stack_simple;

import java.util.LinkedList;

public class BackspaceCompare {

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        System.out.println(backspaceCompare.backspaceCompare("a##c", "a##c"));
    }

    public boolean backspaceCompare(String S, String T) {

        LinkedList<Character> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();

        char[] chars1 = S.toCharArray();
        char[] chars2 = T.toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;

        for (int index = 0; index < len1; index++) {
            Character character = chars1[index];
            if (character == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(character);
            }
        }

        for (int index = 0; index < len2; index++) {
            Character character = chars2[index];
            if (character == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(character);
            }
        }

        return String.valueOf(stack1).equals(String.valueOf(stack2));
    }

}

