package edu.xidian.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther youbing
 * @date 2018/11/12 20:33
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class LeetCode_129 {

    public int sumNumbers(TreeNode root) {
        return sumPath(root,0);
    }


    private int sumPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumPath(root.left, sum) + sumPath(root.right, sum);
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3};
        TreeNode root = CreateTree.constructTree(nums);
        LeetCode_129 leetCode_129 = new LeetCode_129();
        int i = leetCode_129.sumNumbers(root);
        System.out.println(i);
    }
}
