package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:53
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 思路：根节点到叶子节点，因此每一个节点都必须有，所以每经过一个节点就减去该节点的value值，如果最后发现一个节点是
 * 叶子节点（root.left == null && root.right == null），则判断该节点的值与剩余的sum值是否相等
 */
public class LeetCode_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        if (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)) {
            return true;
        }
        return false;
    }

}
