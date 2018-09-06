package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/22
 * @des
 */
public class Solution45B {



    public boolean isContinuous(int[] array) {

        if (array == null || array.length < 5) {
            return false;
        }

        selection(array);

        int numberOfZero =0;

        for(int i=0;i<array.length;i++) {
            if (array[i] == 0) {
                numberOfZero++;
            }
        }

        int numberOfGap = 0;

        for(int i=numberOfZero+1;i<array.length;i++) {
            if(array[i]==array[i-1])
                return false;
            numberOfGap += array[i] - array[i - 1] - 1;
        }


        return numberOfZero>=numberOfGap?true:false;
    }

    private void selection(int[] num) {

        int N = num.length;

        int min = 0;

        for(int i=0;i<N;i++) {

            min = i;

            for(int j=i+1;j<N;j++) {
                if(less(num[j],num[min])) min = j;
            }

            swap(num, i, min);
        }


    }

    private boolean less(int i, int j) {
        return i < j;
    }

    private void swap(int[] num,int i,int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

}
