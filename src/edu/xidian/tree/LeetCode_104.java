package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:30
 */
public class LeetCode_104 {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
