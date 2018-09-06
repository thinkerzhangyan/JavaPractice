package jianzhioffer;

import java.util.HashMap;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 第一个只出现一次的字符
 */
public class Solution34 {

    public int firstNotRepeatCharA(String string) {

        if (string == null || string.length() == 0) {
            return -1;
        }

        char[] chars = string.toCharArray();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char ch : chars) {
            if (hashMap.get(ch) == null) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, hashMap.get(ch)+1);
            }
        }

        int i = 0;

        for(;i<chars.length;i++) {
            if (hashMap.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }


    public int firstNotRepeatCharB(String string) {
        if (string == null || string.length() == 0) {
            return -1;
        }

        char[] hashArray = new char[58];

        char[] chars = string.toCharArray();

        char standard = 'A';

        for (char c : chars) {
            hashArray[c - standard] +=1;
        }

        for(int i=0;i<chars.length;i++) {
            if (hashArray[chars[i] - standard] == 1) {
                return i;
            }
        }

        return -1;
    }


}
