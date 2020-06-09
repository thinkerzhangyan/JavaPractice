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
        boolean result = false;

        int rows = array.length;
        int columns = array[0].length;

        int rowIndex = 0;
        int columnIndex = columns - 1;

        while (rowIndex < rows && columnIndex >= 0) {
            if (array[rowIndex][columnIndex] == target) {
                return true;
            } else if (array[rowIndex][columnIndex] < target) {
                rowIndex++;
            } else if (array[rowIndex][columnIndex] > target) {
                columnIndex--;
            }
        }

        return result;
    }

}
