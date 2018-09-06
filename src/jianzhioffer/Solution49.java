package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des 把字符串转换成整数
 */
public class Solution49 {

    public static void main(String[] args) {
        System.out.println(strToInt("+"));
        System.out.println(strToInt("-"));
    }

    //http://wuchong.me/blog/2014/03/17/string-to-int/
    public static int strToInt(String str) {

        if (str == null || str.trim().length() == 0) {
            return 0;
        }

        int tag = 0;
        int start = 0;

        if (str.charAt(0) == '-') {
            tag = 1;
            start = 1;
        } else if (str.charAt(0) == '+') {
            tag = 0;
            start = 1;
        } else if (str.charAt(0) == '0') {
            return 0;
        } else {
            tag = 0;
            start = 0;
        }

        final int MAX_DIV = Integer.MAX_VALUE / 10;
        final int MAX_MOD = Integer.MAX_VALUE % 10;

        int MIN_DIV = -(Integer.MIN_VALUE / 10);
        int MIN_MOD = - (Integer.MIN_VALUE % 10);

        char[] chars = str.toCharArray();

        int result = 0;

        int digit = 0;

        for (int i = start; i < chars.length; i++) {

            if ('0' <= chars[i] && chars[i] <= '9') {
                digit = chars[i] - '0';
                if (i == start) {
                    if (digit == 0) {
                        return 0;
                    }
                }
                if (tag == 0 && (result > MAX_DIV || (result == MAX_DIV && digit > MAX_MOD))) {
                    throw new RuntimeException("上溢出");
                } else if (tag == 1 && (result > MIN_DIV || (result == MIN_DIV && digit > MIN_MOD))) {
                    throw new RuntimeException("下溢出");
                }
                result = result * 10 + digit;
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
