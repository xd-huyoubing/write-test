package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:53
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class LeetCode_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = hight(root.left);
        int right = hight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) || isBalanced(root.right);
    }

    private int hight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(hight(node.left), hight(node.right)) + 1;
    }
}
