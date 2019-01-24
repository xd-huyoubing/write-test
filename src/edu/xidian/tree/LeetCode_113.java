package edu.xidian.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/12 20:33
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 思路：主要思路是回溯法，变量二叉树，遇到叶子节点判断和是否等于sum,不等于则回溯到上一个节点，接着判断。
 */
public class LeetCode_113 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return res;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(list));
        }
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        list.removeLast();
        return res;
    }

    /**
     * 两种方法都行
     *
     * @param args
     */
    /*private void searchPathSum(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(list));
        }
        searchPathSum(root.left, sum - root.val, list);
        searchPathSum(root.right, sum - root.val, list);
        list.removeLast();
    }*/
    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = CreateTree.constructTree(nums);
        LeetCode_113 leetCode_113 = new LeetCode_113();
        leetCode_113.pathSum(root, 22);
    }

}
