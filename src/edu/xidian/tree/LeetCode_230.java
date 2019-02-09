package edu.xidian.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/12 20:59
 * <p>
 * 思路：中序遍历 然后遇到第key小的元素时终止遍历
 */
public class LeetCode_230 {
    private List<Integer> list = new ArrayList<>();

    /* public int kthSmallest(TreeNode root, int k) {
         preOrder(root);
         return list.get(k);
     }

     private void preOrder(TreeNode node) {
         if (node == null) {
             return;
         }
         preOrder(node.left);
         list.add(node.val);
         preOrder(node.right);
     }*/
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;

    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        res++;
        if (res == k) {
            res = node.val;
            return;
        }
        inOrder(node.right, k);
        return;
    }
}
