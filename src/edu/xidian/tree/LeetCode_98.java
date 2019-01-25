package edu.xidian.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther youbing
 * @date 2018/11/12 20:58
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 思路：
 * （1）二分搜索树的中序遍历是一个有序的数组  判断是否是有序的数组即可
 * （2）二分搜索树的特点是左<根<右，可以利用这个性质
 */
public class LeetCode_98 {
    List<Integer> list = new ArrayList<>();
    long v = Long.MIN_VALUE;

    /**
     * 方法二 二分搜索树的特点是左<根<右，可以利用这个性质
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(isValidBST1(root.left)) {
            if (v < root.val) {
                v = root.val;
                return isValidBST1(root.right);
            }
        }
        return false;
    }

    /**
     * 方法一  利用二分搜索树的定义解决
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
}
