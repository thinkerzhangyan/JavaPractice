package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution1B {

    public boolean find(int target, int[][] array) {

        if (array == null || array.length == 0) {
            return false;
        }

        int row = array.length;
        int column = array[0].length;

        int rowIndex = 0;
        int columnIndex = column - 1;

        while (rowIndex < row && columnIndex >= 0) {
            if (array[rowIndex][columnIndex] == target) {
                return true;
            } else if (array[rowIndex][columnIndex] < target) {
                rowIndex++;
            } else {
                columnIndex--;
            }
        }

        return false;

    }

}
