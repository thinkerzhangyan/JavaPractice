package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des
 */
public class Solution27B {

    public ArrayList<String> permutation(String string) {

        ArrayList<String> list = new ArrayList<>();

        if (string == null || string.length() == 0) {
            return list;
        }

        char[] chars = string.toCharArray();


        permutationHelper(chars, 0, list);

        Collections.sort(list);

        return list;
    }

    private void permutationHelper(char[] chars, int index, ArrayList<String> list) {

        if (index == chars.length) {
            if (!list.contains(String.valueOf(chars))) {
                list.add(String.valueOf(chars));
            }
        } else {
            for(int i=index;i<chars.length;i++) {
                swap(chars, index, i);
                permutationHelper(chars, index + 1, list);
                swap(chars, index, i);
            }
        }

    }

    private void swap(char[] chars, int index, int i) {
        char tmp = chars[index];
        chars[index] = chars[i];
        chars[i] = tmp;
    }

}
