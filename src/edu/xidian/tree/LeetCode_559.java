package edu.xidian.tree;

import java.util.List;

/**
 * @author 有兵
 * @date 2019/1/22 10:32
 * 给定一个 N 叉树，找到其最大深度。
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class LeetCode_559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node node : root.children) {
            depth = Math.max(maxDepth(node), depth);
        }
        //+1是加上当前节点的这一层
        return depth + 1;
    }
}
