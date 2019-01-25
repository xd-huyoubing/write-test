package edu.xidian.tree;

/**
 * @auther huyoubing
 * @date 2018/11/12 20:46
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 思路：分为两种情况，需要当前节点，不需要当前节点
 */
public class LeetCode_437 {
    public int pathSum(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        //在以node为根节点的二叉树中寻找包含当前节点的路径和为sum的数量
        res += findPath(root, sum);
        //在左子树中寻找不包含root节点的数量
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    //在以node为根节点的二叉树中寻找包含当前节点的路径和为sum的数量
    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val == sum) {
            count += 1;
        }
        count += findPath(node.left, sum - node.val);
        count += findPath(node.right, sum - node.val);
        return count;
    }

    public static void main(String[] args) {
        Integer[] nums = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = CreateTree.constructTree(nums);
        LeetCode_437 leetCode_437 = new LeetCode_437();
        int i = leetCode_437.pathSum(root, 8);
        System.out.println(i);

    }
}
