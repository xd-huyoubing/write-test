package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 20:59
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class LeetCode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //找到需要删除的节点
        TreeNode deleteNode = findNode(root, key);
        if (deleteNode != null) {
            //如果要删除的节点是叶子节点直接删除
            if (deleteNode.left == null && deleteNode.right == null) {


                //要删除的节点左子树或者右子树有一个为null
            } else if (deleteNode.left == null || deleteNode.right == null) {

                //都不为null
            } else {

            }
        }

        return root;
    }

    private TreeNode findNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.val == key) {
            return node;
        }
        findNode(node.left, key);
        findNode(node.right, key);
        return null;
    }
}
