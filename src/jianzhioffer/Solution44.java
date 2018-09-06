package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/18
 * @des 翻转单词顺序列
 */
public class Solution44 {

    public static void main(String[] args) {
        System.out.println(reverStringA("I am a student."));
    }

    public static String reverStringA(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();

        int head = 0;
        int tail = chars.length - 1;

        ReverseHelper(chars, head, tail);


        head = 0;
        tail = 0;

        while (head < chars.length) {

            if (tail == chars.length || chars[tail] == ' ') {
                tail--;
                ReverseHelper(chars, head, tail);
                tail+=2;
                head = tail;
            } else {
                tail++;
            }

        }


        return new String(chars);

    }

    public static String reverStringB(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chars = str.toCharArray();


        int head = 0;
        int tail = 0;

        while (head < chars.length) {

            if (tail == chars.length || chars[tail] == ' ') {
                tail--;
                ReverseHelper(chars, head, tail);
                tail+=2;
                head = tail;
            } else {
                tail++;
            }

        }

        head = 0;
        tail = chars.length - 1;

        ReverseHelper(chars, head, tail);


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
