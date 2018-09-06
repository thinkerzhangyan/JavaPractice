package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 左旋转字符串
 */
public class Solution43 {

    public String leftRotateStringA(String str, int n) {

        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();

        ReverseHelper(chars, 0, n-1);
        ReverseHelper(chars, n, chars.length - 1);
        ReverseHelper(chars, 0, chars.length - 1);

        return new String(chars);

    }

    public String leftRotateStringB(String str, int n) {

        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();

        ReverseHelper(chars, 0, chars.length - 1);
        ReverseHelper(chars, 0, chars.length-n-1);
        ReverseHelper(chars, chars.length-n, chars.length - 1);

        return new String(chars);

    }

    private static void ReverseHelper(char[] chars, int head, int tail) {

        while (head < tail) {

            char tmp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = tmp;

            head++;
            tail--;

        }

    }

}
