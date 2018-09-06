package jianzhioffer;

import java.util.ArrayList;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 顺时针打印矩阵
 */
public class Solution19 {

    public ArrayList<Integer> printMatrix(int[][] array) {

        ArrayList<Integer> list = new ArrayList<>();

        int columns = array[0].length;
        int rows = array.length;

        if (array == null || columns <= 0 || rows <= 0) {
            return list;
        }

        int start=0;

        while (columns > start * 2 && rows > start * 2) {
            printMatrixCicle(array, rows, columns, start, list);
            start++;
        }

        return list;
    }

    private void printMatrixCicle(int[][] array, int rows, int columns, int start, ArrayList<Integer> list) {

        int endX = columns  - 1 - start;
        int endY = rows - 1 - start;

        for(int i=start;i<=endX;i++) {
            list.add(array[start][i]);
        }

        if (start < endY) {
            for(int i=start+1;i<=endY;i++) {
                list.add(array[i][endX]);
            }
        }

        if (start < endX && start < endY) {
            for (int i=endX-1;i>=start;i--) {
                list.add(array[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i=endY-1;i>start;i--) {
                list.add(array[i][start]);
            }
        }


    }
}
