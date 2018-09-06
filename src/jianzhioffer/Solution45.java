package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des 扑克牌顺子
 */
public class Solution45 {


    public boolean isContinuous(int[] num) {

        if (num == null || num.length < 5) {
            return false;
        }

        selection(num);

        int numberOfZero = 0;

        for(int i=0;i<num.length;i++) {
            if(num[i]==0)
                numberOfZero++;
        }

        int numberOfGap = 0;

        for(int i=numberOfZero+1;i<num.length;i++) {
            if(num[i]==num[i-1])
                return false;
            numberOfGap+=num[i]-num[i-1]-1;
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
