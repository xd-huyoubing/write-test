package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:40
 */
public class LeetCode_111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0)
            return rightDepth + 1;
        if (rightDepth == 0)
            return leftDepth + 1;
        return Math.min(leftDepth,rightDepth) + 1;
    }
}
