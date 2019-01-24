package edu.xidian.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther huyoubing
 * @date 2018/11/12 15:53
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 * <p>
 * 思路：两棵树递归比较值是否相等即可,非递归直接使用队列保存比较即可
 */
public class LeetCode_100 {
    //递归算法实现
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //如果两棵树都是null,则是相等的 返回true
        if (p == null && q == null) {
            return true;
        }
        //如果两棵树中有一颗数树是null,肯定不相等，因此直接返回false
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //非递归算法实现
    public boolean isSameTreeNR(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.left);
            queue.add(t1.right);
            queue.add(t2.right);
        }
        return true;
    }

}
