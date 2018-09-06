package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution43B {

    public String leftRotateStringA(String string,int k) {

        if (string == null || string.length() == 0 || k < 0) {
            return string;
        }

        char[] chars = string.toCharArray();

        reverHelper(chars,0, k-1);
        reverHelper(chars, k, chars.length - 1);
        reverHelper(chars, 0, chars.length - 1);

        return new String(chars);

    }

    public String leftRotateStringB(String string,int k) {

        if (string == null || string.length() == 0 || k < 0) {
            return string;
        }

        char[] chars = string.toCharArray();

        reverHelper(chars, 0, chars.length - 1);
        reverHelper(chars, 0, chars.length - k-1);
        reverHelper(chars,chars.length-k, chars.length-1);


        return new String(chars);

    }

    private void reverHelper(char[] chars, int head, int tail) {

        while (head < tail) {
            char tmp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = tmp;
            head++;
            tail--;
        }

    }

}
