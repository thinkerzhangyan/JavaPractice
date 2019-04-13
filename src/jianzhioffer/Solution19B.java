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


        int rows = array.length;
        int columns = array[0].length;

        if (array == null || columns <= 0 || rows <= 0) {
            return list;
        }

        int start = 0;

        while (start * 2 < rows && start * 2 < columns) {
            printMatrixInCircle(array, start, rows, columns, list);
            start++;
        }

        return list;
    }

    private static void printMatrixInCircle(int[][] array, int start, int rows, int columns, ArrayList<Integer> list) {

        int endY = rows - start - 1;
        int endX = columns - start - 1;

        for (int i = start; i <= endX; i++) {
            list.add(array[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(array[i][endX]);
            }
        }

        if (start < endY && start < endY) {
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
