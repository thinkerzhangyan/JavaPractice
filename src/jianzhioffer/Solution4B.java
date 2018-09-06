package jianzhioffer;

/**
 * @author zhangyan
 * @date 2018/1/16
 * @des
 */
public class Solution4B {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }

        return reConstructBinaryTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeHelper(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn) {

        if (startIn > endPre || startIn > endIn) {
            return null;
        }

        TreeNode treeNode = new TreeNode(pre[startPre]);

        for(int index=startIn;index<=endIn;index++) {
            if (pre[startPre] == in[index]) {
                treeNode.left = reConstructBinaryTreeHelper(pre, startPre + 1, startPre - startIn + index, in, 0, index - 1);
                treeNode.right = reConstructBinaryTreeHelper(pre, startPre - startIn + index + 1, endPre, in,index + 1, endIn);
            }
        }

        return treeNode;
    }
}
