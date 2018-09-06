package jianzhioffer;

import sort.Insertion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 顺时针打印矩阵
 */
public class Solution19B {

    public ArrayList<Integer> printMatrix(int[][] array) {

        ArrayList<Integer> list = new ArrayList<>();

        int rows = array.length;
        int columns = array[0].length;

        if (array == null || rows == 0 || columns == 0) {
            return list;
        }

        int start = 0;

        while (rows > 2 * start && columns > start * 2) {
            printMatrixInCicle(array, rows, columns, start, list);
            start++;
        }

        return list;

    }

    private void printMatrixInCicle(int[][] array, int rows, int columns, int start, ArrayList<Integer> list) {

        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        for (int i = start; i <= endX; i++) {
            list.add(array[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(array[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(array[endY][i]);
            }
        }

        if (start < endX && endY - start > 1) {
            for (int i = endY - 1; i > start; i--) {
                list.add(array[i][start]);
            }
        }

    }


}
