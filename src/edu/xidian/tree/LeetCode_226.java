package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:49
 */
public class LeetCode_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
