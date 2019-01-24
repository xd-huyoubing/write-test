package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:53给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class LeetCode_222 {


    /**
     *直接遍历求出所有的节点
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        res += countNodes(root.left);
        res += countNodes(root.right);
        return res + 1;
    }
}
