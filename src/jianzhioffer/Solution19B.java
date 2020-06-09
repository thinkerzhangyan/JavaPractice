package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 顺时针打印矩阵
 */
public class Solution19B {

    public static void main(String[] args) {

        int[][] array = new int[][]{{1}};

        List<Integer> list = printMatrix(array);

        System.out.println(list);

    }

    public static ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return list;
        }
        int start = 0;
        int rows = array.length;
        int columns = array[0].length;
        while (start * 2 < rows && start * 2 < columns) {
            printMatrix(array, start, rows, columns, list);
            start++;
        }
        return list;
    }

    private static void printMatrix(int[][] array, int start, int rows, int columns, ArrayList<Integer> list) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        for (int index = start; index <= endX; index++) {
            list.add(array[start][index]);
        }

        if (start < endY) {
            for (int index=start+1;index<=endY;index++) {
                list.add(array[index][endX]);
            }
        }

        if (start < endY && start < endX) {
            for (int index=endX-1;index>=start;index--) {
                list.add(array[endY][index]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int index=endY-1;index>start;index--) {
                list.add(array[index][start]);
            }
        }

    }

}
