package jianzhioffer;

/**
 * @author zhangyan
 * @date 2017/10/19
 * @des 根据前序序列和中序序列重建二叉树
 */
public class Solution4 {


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = 0; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre - startIn + i, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre - startIn + i + 1, endPre, in, i + 1, endIn);
            }
        }

        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}