package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/24
 * @des
 */
public class Solution54B {

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

        int tmpIndex = Integer.MAX_VALUE;

        char result = '#';

        for (int i = 0; i < 256; i++) {
            if (hashMap[i] != 0 && hashMap[i] != -1 && hashMap[i] < tmpIndex) {
                result = (char) i;
                tmpIndex = hashMap[i];
            }
        }

        return result;
    }
}
