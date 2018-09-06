package jianzhioffer;

import java.util.HashMap;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution34B {

    public static void main(String[] args) {
        System.out.println("google".indexOf(1));
    }

    public int findFirstNoRepeatCharacterA(String string) {

        if (string == null || string.length() == 0) {
            return -1;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        char[] chars = string.toCharArray();

        for (char ch : chars) {

            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }

        }

        int i = 0;

        for (; i < chars.length; i++) {

            if (hashMap.get(chars[i]) == 1) {
                return i;
            }

        }

        return -1;
    }

    public int findFirstNoRepeatCharacterB(String string) {

        if (string == null || string.length() == 0) {
            return -1;
        }

        char[] hashArray = new char[58];

        for (int i = 0; i < string.length(); i++) {
            hashArray[string.charAt(i) - 'A'] += 1;
        }

        for (int i = 0; i < string.length(); i++) {
            if (hashArray[string.charAt(i) - 'A'] == 1)
                return i;
        }

        return -1;

    }

}