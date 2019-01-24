package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 20:22
 * 计算给定二叉树的所有左叶子之和。
 */
public class LeetCode_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return preOder(root, false);
    }

    private int preOder(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
        }
        sum += preOder(root.left, true);
        sum += preOder(root.right, false);
        return sum;
    }
}
