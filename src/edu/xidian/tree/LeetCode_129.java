package edu.xidian.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
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
    private List<String> list = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        List<String> list = sumPath(root,new StringBuilder());

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }

    private List<String> sumPath(TreeNode root,StringBuilder builder) {
        if (root == null) {
            return null;
        }
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(new String(builder));
            builder.delete(0,builder.length()-1);
        }

        List<String> leftSum = sumPath(root.left,builder);
        for (int i = 0; i < leftSum.size(); i++) {
            builder.append(root.val + leftSum.get(i));
        }
        List<String> rightSum = sumPath(root.right,builder);

        for (int i = 0; i < rightSum.size(); i++) {
            builder.append(root.val + rightSum.get(i));
        }

        return list;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3};
        TreeNode root = CreateTree.constructTree(nums);
        LeetCode_129 leetCode_129 = new LeetCode_129();
        int i = leetCode_129.sumNumbers(root);
        System.out.println(i);
    }
}
