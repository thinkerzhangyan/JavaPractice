package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution2B {

    public static String replaceSpaceA(StringBuffer str) {
        if (str == null) {
            return null;
        }

        if (str.length() == 0) {
            return str.toString();
        }
        return str.toString().replace(" ", "%20");
    }

    public static String replaceSpaceB(StringBuffer str) {
        if (str == null) {
            return null;
        }

        if (str.length() == 0) {
            return str.toString();
        }

        char[] originChars = str.toString().toCharArray();

        int spaceCounts = 0;

        int originCharsLength = originChars.length;

        for (int i = 0; i < originCharsLength; i++) {
            if (originChars[i] == ' ') {
                spaceCounts++;
            }
        }

        char[] newChars = new char[originCharsLength + spaceCounts * 2];

        int j = 0;

        for (int i = 0; i < originCharsLength; i++) {
            if (originChars[i] != ' ') {
                newChars[j] = originChars[i];
                j++;
            } else {
                newChars[j++] = '%';
                newChars[j++] = '2';
                newChars[j++] = '0';
            }
        }

        return new String(newChars);
    }

    public static String replaceSpaceC(StringBuffer str) {
        if (str == null) {
            return null;
        }

        if (str.length() == 0) {
            return str.toString();
        }


        int spaceCounts = 0;

        int originCharsLength = str.toString().length();

        for (int i = 0; i < originCharsLength; i++) {
            if (str.charAt(i) == ' ') {
                spaceCounts++;
            }
        }

        char[] newChars = new char[originCharsLength + spaceCounts * 2];

        System.arraycopy(str.toString().toCharArray(), 0, newChars, 0, originCharsLength);

        int j = newChars.length-1;

        for (int i = originCharsLength - 1; i >= 0; i--) {
            if (newChars[i] == ' ') {
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
            } else {
                newChars[j--] = newChars[i];
            }
        }

        return new String(newChars);
    }


    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        replaceSpaceC(stringBuffer);
    }
}
