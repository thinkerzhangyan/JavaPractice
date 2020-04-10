package leetcode.stack_simple;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidBracket {

    private HashMap<Character, Character> hashMap = new HashMap<>();
    {
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
    }

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Character tmpChar = s.charAt(i);
            if (hashMap.containsKey(tmpChar)) {
                Character topChar = stack.peek();
                if (hashMap.get(tmpChar) == topChar) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(tmpChar);
            }
        }

        return stack.isEmpty();
    }
}
