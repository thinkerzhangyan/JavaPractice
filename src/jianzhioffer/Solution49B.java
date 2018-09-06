package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/22
 * @des
 */
public class Solution49B {

    public static void main(String[] args) {


        try {
            System.out.println(strToInt("-2147483649"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int strToInt(String str) throws Exception {

        if (str == null || str.trim().length() == 0) {
            return 0;
        }

        int tag = 0;
        int start = 0;

        char[] chars = str.toCharArray();

        if (chars[0] == '-') {
            tag = 1;
            start = 1;
        } else if (chars[0] == '+') {
            tag = 0;
            start = 1;
        } else {
            tag=0;
            start = 0;
        }

        int result =0;

        int MAX_DIV = Integer.MAX_VALUE/10;
        int MAX_MOD = Integer.MAX_VALUE % 10;

        int MIN_DIV = -(Integer.MIN_VALUE/10);
        int MIN_MOD = -(Integer.MIN_VALUE % 10);

        int digit=0;

        for(int i=start;i<chars.length;i++) {

            if ('0' <= chars[i] && chars[i] <= '9') {
                digit = chars[i] - '0';
                if (i == start) {
                    if (digit == 0) {
                        return 0;
                    }
                }

                if (tag == 0 && (result > MAX_DIV || (result == MAX_DIV && digit > MAX_MOD))) {
                    throw new Exception("上溢出");
                } else if (tag == 1 && (result > MIN_DIV || (result == MIN_DIV && digit > MIN_MOD))) {
                    throw new Exception("下溢出");
                } else {
                    result = result * 10 + digit;
                }

            } else {
                return 0;
            }

        }

        if (tag == 1) {
            result = -result;
        }

        return result;
    }
}