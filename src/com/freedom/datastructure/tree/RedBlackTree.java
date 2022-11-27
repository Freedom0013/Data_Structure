package com.freedom.datastructure.tree;

/**
 * 红黑树实现
 * 基于标准二叉查找树实现,通过颜色反转来保证树的平衡性，降低树高度提高查询效率
 * @author Freedom0013 @Date 2022-11-27
 * @version V1.00
 */
public class RedBlackTree <Key extends Comparable<Key>,Value>{
    /** 红色链接 */
    private static final boolean RED = true;
    /** 黑色链接 */
    private static final boolean BLACK = false;
    /** 根节点 */
    private Node root;
    /** 红黑树大小 */
    private int size;

    public RedBlackTree() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 判断是否为红链接
     * @param node 叶子结点
     * @return boolean 是否是红链接
     */
    public boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    /**
     * 红黑树节点左旋
     *                  E
     *               ╱     ╲红
     *            小于E      S
     *                   ╱      ╲
     *            介于E、S之间   大于S
     *
     *                  S
     *               ╱红    ╲
     *              E      大于S
     *           ╱     ╲
     *        小于E   介于E、S之间
     *
     * @param eNode 旋转节点E
     * @return com.freedom.datastructure.tree.RedBlackTree<Key,Value>.Node 左旋完成节点
     */
    private Node rotateLeft(Node eNode) {
        Node sNode = eNode.right;    //记录当前节点右子节点（注释图E的右子节点S）
        eNode.right = sNode.left;    //将介于E/S之间的节点直接链接在E的右子节点上
        sNode.left = eNode;          //旋转树枝，使S/E互换位置
        sNode.color = eNode.color;  //使得S节点变为黑色链接
        eNode.color = RED;          //E节点变为红色链接
        return sNode;
    }

    /**
     * 红黑树节点右旋
     *                  S
     *               ╱红    ╲
     *              E      大于S
     *           ╱红    ╲
     *        小于E   介于E、S之间
     *
     *                  E
     *                ╱   ╲红
     *             小于E     S
     *                   ╱     ╲
     *            介于E、S之间  大于S
     *
     * @param sNode 旋转节点
     * @return com.freedom.datastructure.tree.RedBlackTree<Key,Value>.Node 右旋完成节点
     */
    private Node rotateRight(Node sNode) {
        Node eNode = sNode.left;
        sNode.left = eNode.right;
        eNode.right = sNode;
        eNode.color = sNode.color;
        sNode.color = RED;
        return eNode;
    }

    /**
     * 反转颜色
     * @param node 反转节点
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 插入元素
     * @param key 键
     * @param value 值
     */
    public void put(Key key, Value value) {
        root = put(root,key,value);
        root.color = RED; //不管如何插入，根节点颜色总是黑色
    }

    /**
     * 在指定节点插入元素
     * @param key   键
     * @param value 值
     * @param node  插入节点
     * @return com.freedom.datastructure.tree.RedBlackTree<Key, Value>.Node 完成插入节点
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null) {   //判断节点是否为空，为空则返回一个红色节点
            size++;
            return new Node(key, value, null, null, RED);
        }
        //比较当前节点的键和key大小
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {  //继续往左加
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {//继续往右加
            node.right = put(node.right, key, value);
        } else {//重复值替换
            node.value = value;
        }
        //需要左旋
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        //需要右旋
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        //需要颜色反转
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    /**
     * 根据键值获取元素
     * @param key 键
     * @return Value 获取的元素值
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 根据键值获取元素
     * @param node 子树根节点
     * @param key 键
     * @return Value 获取的元素值
     */
    private Value get(Node node, Key key) {
        if (node == null || isEmpty()) {
            return null;
        }
        //如果子树不为空，则比较key值大小，大于递归找右子树，小于找左子树，等于即找到，返回元素值
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }
    }

    /** 红黑树叶子节点 */
    private class Node {
        /** 左叶子节点 */
        private Node left;
        /** 右叶子节点 */
        private Node right;
        /** 键值 */
        private Key key;
        /** 叶子值 */
        private Value value;
        /** 红黑链接区分 */
        private boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
}
