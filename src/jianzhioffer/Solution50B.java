package jianzhioffer;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhangyan
 * @date 2018/1/22
 * @des
 */
public class Solution50B {
    public boolean duplicateB(int numbers[], int length, int[] duplication) {

        if (numbers == null || numbers.length == 0) {
            return false;
        }

        for (int i=0;i<numbers.length;i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) {
                return false;
            }
        }

        for (int i=0;i<numbers.length;i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                exch(numbers, numbers[i], i);
            }
        }


        return false;
    }


    private void exch(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}