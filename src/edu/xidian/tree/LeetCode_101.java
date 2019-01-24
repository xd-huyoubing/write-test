package edu.xidian.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:53
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 思路：将其分解为两棵树，比较两棵树对应的值就可以解决
 */
public class LeetCode_101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    //非递归解法
    private boolean isMirrorNR(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    //递归解法
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
