package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/23
 * @des 字符流中第一个不重复的字符
 */
public class Solution54 {

    private int[] hashMap = new int[256];

    private int index = 1;

    public void insert(char ch) {
        if (hashMap[ch] == 0) {
            hashMap[ch] = index++;
        } else {
            hashMap[ch] = -1;
        }
    }


    public char firstApperanceOne() {

        char result = '#';

        int tmpIndex = Integer.MAX_VALUE;

        for(int i=0;i<256;i++) {
            if (hashMap[i] != 0 && hashMap[i] != -1 && hashMap[i] < tmpIndex) {
                tmpIndex = hashMap[i];
                result = (char) i;
            }
        }


        return result;
    }

}
