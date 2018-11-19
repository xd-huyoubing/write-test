package edu.xidian.stackAndqueue.queue;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther huyoubing
 * @date 2018/11/8 9:03
 *
 * 思路：
 */
public class LeetCode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> pair = queue.removeFirst();
            TreeNode cur = pair.getKey();
            Integer level = pair.getValue();
            if (level == result.size())
                result.add(new ArrayList());

            result.get(level).add(cur.val);

            if (cur.left != null) {
                queue.add(new Pair(cur.left, level + 1));
            }
            if (cur.right != null) {
                queue.add(new Pair(cur.right, level + 1));
            }
        }
        return result;
    }
}
