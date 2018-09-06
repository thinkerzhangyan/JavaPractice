package jianzhioffer;

import java.util.ArrayList;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des 从上往下打印二叉树
 */
public class Solution22 {

    public ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        for(int level=0;;level++) {
            if (!printNodeAtLevel(root, level, list)) {
                return list;
            }
        }
    }

    private boolean printNodeAtLevel(TreeNode root, int level,ArrayList<Integer> list) {

        if (root == null || level < 0) {
            return false;
        }

        if (level == 0) {
            list.add(root.val);
            return true;
        }

        boolean left = printNodeAtLevel(root.left, level - 1, list);
        boolean right = printNodeAtLevel(root.right, level - 1, list);

        return left || right;
    }

}
