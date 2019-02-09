package edu.xidian.binarysearch;

import java.util.Stack;

/**
 * @author 有兵
 * @date 2019/1/25 15:52
 * <p>
 * 二分搜索树的基本操作
 * <p>
 * 泛型指定E的上界，说明传入的元素必须是可比较的类型
 */
public class BST<E extends Comparable<E>> {

    /**
     * 二分搜索树的节点类型
     */
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获取二分搜索树的节点个数
     *
     * @return 返回节点个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断二分搜索树是否为null
     *
     * @return 如果二分搜索树为null, 则返回true否则返回false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 递归算法
     * 向二分搜索树中添加一个元素e
     *
     * @param e 需要添加的元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 非递归算法
     * 向二分搜索树中添加一个元素
     *
     * @param e 需要添加的元素
     */
    public void addNR(E e) {
        if (root == null) {
            size++;
            root = new Node(e);
            return;
        }
        Node node = root;
        while (node != null) {
            if (e.compareTo(node.e) < 0) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    size++;
                    node.left = new Node(e);
                    return;
                }
            } else if (e.compareTo(node.e) > 0) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    size++;
                    node.right = new Node(e);
                    return;
                }
            }
        }
    }

    /**
     * 递归算法：
     * 判断二分搜索树中是否存在指定的元素
     *
     * @param e 需要查找的元素
     * @return 如果包含则返回true否则返回false
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }


    /**
     * 非递归算法：
     * 判断二分搜索树中是否存在指定的元素
     *
     * @param e 需要查找的元素
     * @return 如果包含则返回true否则返回false
     */
    public boolean containsNR(E e) {
        if (root == null) {
            return false;
        }
        Node node = root;
        while (node != null) {
            if (e.compareTo(node.e) == 0) {
                return true;
            } else if (e.compareTo(node.e) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    /**
     * 递归算法
     * 先序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 先序遍历以node为根节点的二分搜索树
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归算法
     * 先序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 递归算法
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根节点的二分搜索树
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 非递归算法
     * 中序遍历
     */
    public void inOrderNR() {

    }

    /**
     * 递归算法
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根节点的二分搜索树
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 非递归算法
     * 后续遍历
     */
    public void postOrderNR() {

    }

    /**
     * 获取二分搜索树的最小值
     *
     * @return
     */
    public E getMin() {
        Node node = getMin(root);
        return node.e;
    }

    /**
     * 获取以node为根节点的二分搜索树的最小值
     *
     * @param node
     * @return
     */
    private Node getMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);

    }

    public E getMinNR() {
        return getMinNR(root).e;
    }

    private Node getMinNR(Node node) {

        while (node != null) {
            if (node.left == null) {
                return node;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    /**
     * 获取二分搜索树的最大值  递归写法
     *
     * @return
     */
    public E getMax() {
        return getMax(root).e;
    }

    private Node getMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    /**
     * 获取二分搜索树的最大值  非递归写法
     *
     * @return
     */
    public E getMaxNR() {
        return getMaxNR(root).e;
    }

    private Node getMaxNR(Node node) {
        while (node != null) {
            if (node.right == null) {
                return node;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    /**
     * 删除二分搜索树的最小值 并将最小值返回
     */
    public E removeMin() {
        E min = getMinNR();
        root = removeMin(root);
        return min;
    }

    /**
     * 删除以node为根节点的二分搜索树，返回删除后新的二分搜索树的根节点
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树的最大值 并将最大值返回
     *
     * @return
     */
    public E removeMax() {
        E e = getMax();
        root = removeMax(root);
        return e;
    }

    /**
     * 删除以node为根节点的二分搜索树的最大值
     *
     * @param node
     * @return 返回删除最大值后二分搜索树的根节点
     */
    private Node removeMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除二分搜索树的节点的值为E的节点
     *
     * @return
     */
    public void remove(E e) {

        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            //左子树不为null,与删除最大值节点一样
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //右子树不为null，与删除最小值节点一样
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //左右子树都不为null,需要找到后继，即右子树的最小值节点或者左子树的最大值节点
            // 此处为找到右子树的最小值
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = getMin(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = node.left = null;

            return successor;
        }

    }
}
