package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 在行和列都是升序的二维数组中查找元素
 */
public class Solution1 {

    public boolean find(int target,int[][] array) {

        if(array==null||array.length==0)
            return false;

        boolean found = false;

        int row = array.length;
        int column = array[0].length;

        int rowIndex = 0;
        int columnIndex = column-1;

        while ((rowIndex < row) && (columnIndex >= 0)) {

            if (array[rowIndex][columnIndex] < target) {
                rowIndex++;
            } else if (array[rowIndex][columnIndex] > target) {
                columnIndex--;
            } else {
                found = true;
                break;
            }

        }

        return found;
    }



}

