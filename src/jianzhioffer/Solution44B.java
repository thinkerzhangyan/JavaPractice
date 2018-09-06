package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class Solution44B {

    public String reverStringA(String string) {

        if (string == null || string.length() == 0) {
            return string;
        }

        char[] chars = string.toCharArray();

        int head = 0;
        int tail = chars.length - 1;

        reverseHelper(chars, head, tail);

        head = 0;

        tail = 0;


        while (tail <= chars.length) {

            if (tail == chars.length || chars[tail] == ' ') {
                tail--;
                reverseHelper(chars, head, tail);
                tail += 2;
                head = tail;
            }

            tail++;

        }


        return new String(chars);

    }


    public String reverStringB(String string) {

        if (string == null || string.length() == 0) {
            return string;
        }

        char[] chars = string.toCharArray();

        int head = 0;
        int tail = 0;


        while (head < chars.length) {

            if (tail == chars.length || chars[tail] == ' ') {
                tail--;
                reverseHelper(chars, head, tail);
                tail += 2;
                head = tail;
            }

            tail++;

        }

        head = 0;
        tail = chars.length - 1;

        reverseHelper(chars, head, tail);

        return new String(chars);

    }




    private void reverseHelper(char[] chars, int head, int tail) {

        while (head < tail) {
            char tmp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = tmp;
            head++;
            tail--;
        }

    }

}
