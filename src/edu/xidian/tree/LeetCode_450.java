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
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null ) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            TreeNode successor = getMinNode(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }
    }

    /**
     * 删除最小值
     *
     * @param node
     * @return
     */
    private TreeNode removeMin(TreeNode node) {

        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left =  removeMin(node.left);
        return node;
    }

    private TreeNode getMinNode(TreeNode node) {

        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

}
