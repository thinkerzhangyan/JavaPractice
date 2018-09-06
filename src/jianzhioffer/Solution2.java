package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 替换字符串中的空格
 */
public class Solution2 {

    public String replaceSpaceA(StringBuffer str) {

        String strA = str.toString();

        if(strA==null||strA.length()==0)
            return strA;

        char[] chars = strA.toCharArray();

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] != ' ') {
                stringBuffer.append(chars[i]);
            } else {
                stringBuffer.append("%20");
            }
        }

        return stringBuffer.toString();
    }

    public String replaceSpaceB(StringBuffer str) {

        if(str==null||str.length()==0)
            return null;

        char[] chars = str.toString().toCharArray();

        int spaceCount = 0;

        for(int i=0;i<chars.length;i++) {
            if(chars[i]==' ')
                spaceCount++;
        }

        char[] charArray = new char[2*spaceCount+chars.length];

        int index=0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                charArray[index++] = chars[i];
            } else {
                charArray[index++]='%';
                charArray[index++]='2';
                charArray[index++]='0';
            }
        }

        return new String(charArray);

    }

}
