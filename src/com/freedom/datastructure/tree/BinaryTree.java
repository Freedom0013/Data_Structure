package com.freedom.datastructure.tree;

import com.freedom.datastructure.linear.Queue;

/**
 * 二叉查找树
 * @author Freedom0013 @Date 2022-11-21
 * @version V1.00
 */
public class BinaryTree<Key extends Comparable<Key>,Value>{
    /** 树根节点 */
    private Node root;
    /** 树节点数量 */
    private int size;

    public BinaryTree() {
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
     * 插入元素
     * @param key 键
     * @param value 值
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 在指定子树种插入元素
     * @param node 子树根节点
     * @param key 键
     * @param value 值
     * @return com.freedom.datastructure.tree.BinaryTree<Key,Value>.Node 插入完成的根节点位置
     */
    private Node put(Node node, Key key, Value value) {
        //如果子树是空，则创建节点并返回此节点
        if (node == null) {
            size++;
            return new Node(key, value, null, null);
        }
        //如果子树不为空，则比较key值大小，如果传入key大于当前节点key则查找其右子树，小于查找左子树，等于时直接替换value
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
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

    /**
     * 根据key删除元素
     * @param key key值
     * @return Value 被删除元素值
     */
    public Value delete(Key key) {
        return delete(root, key).value;
    }

    /**
     * 删除子树中指定位置元素
     * @param node 子树根节点
     * @param key key值
     * @return com.freedom.datastructure.tree.BinaryTree<Key,Value>.Node 完成删除后子树根节点
     */
    private Node delete(Node node, Key key) {
        if (node == null || isEmpty()) {
            return null;
        }
        //根据key值在左右子树中找到要删除元素
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = delete(node.right, key);
        } else if (cmp < 0) {
            node.left = delete(node.left, key);
        } else {
            size--;
            //删除时，如果被删除元素没有右子树，则其父节点直接指向被删除的左子树
            if (node.right == null) {
                return node.left;
            }
            //删除时，如果被删除元素没有左子树，则其父节点直接指向被删除的右子树
            if (node.left == null) {
                return node.right;
            }
            //如果被删除元素具有左右子树，则删除时需要找到被删除节点的右子树中最小元素，并把它拉取到当前位置替代被删除元素，从而保持二叉树有序
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //遍历找到被删除元素右子树中最小的叶子结点并把它删除（此节点已保存在minNode）
            Node n = node.right;
            while (n.left != null) {    //遍历找到最小子节点的父节点
                if (n.left.left == null) {  //如果此节点左孩子的孩子是空，则代表找到最小节点的父节点，把其联系删除
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            //提取上来的最小节点继承被删除元素的左右子树
            minNode.left = node.left;
            minNode.right = node.right;
            //当前节点的父节点指向提上来的最小节点
            node = minNode;
        }
        return node;
    }

    /**
     * 获取最小元素key值
     * @return Key 最小key
     */
    public Key getMin() {
        return Min(root).key;
    }

    /**
     * 获取子树最小元素key值
     * @param node 子树根节点
     * @return com.freedom.datastructure.tree.BinaryTree<Key,Value>.Node 最小key
     */
    private Node Min(Node node) {
        //不断查找左子树叶子节点
        if (node.left != null) {
            return Min(node.left);
        } else {
            return node;
        }
    }

    /**
     * 获取最大元素key值
     * @return Key 最大key
     */
    public Key getMax() {
        return Max(root).key;
    }

    /**
     * 获取子树最大元素key值
     * @param node 子树根节点
     * @return com.freedom.datastructure.tree.BinaryTree<Key,Value>.Node 最大key
     */
    private Node Max(Node node) {
        //不断查找右子树叶子节点
        if (node.right != null) {
            return Max(node.right);
        } else {
            return node;
        }
    }

    /**
     * 二叉查找树前序遍历
     * @return com.freedom.datastructure.linear.Queue<Key> 遍历完成的key队列
     */
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    /**
     * 二叉查找树前序遍历子树
     * @param node 子树根节点
     * @param keys 存储key值队列
     */
    private void preErgodic(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        keys.enqueue(node.key);
        if (node.left != null) {
            preErgodic(node.left, keys);
        }

        if (node.right != null) {
            preErgodic(node.right, keys);
        }
    }

    /**
     * 二叉查找树中序遍历
     * @return com.freedom.datastructure.linear.Queue<Key> 遍历完成的key队列
     */
    public Queue<Key> minErgodic() {
        Queue<Key> keys = new Queue<>();
        minErgodic(root, keys);
        return keys;
    }

    /**
     * 二叉查找树中序遍历子树
     * @param node 子树根节点
     * @param keys 存储key值队列
     */
    private void minErgodic(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            minErgodic(node.left, keys);
        }
        keys.enqueue(node.key);
        if (node.right != null) {
            minErgodic(node.right, keys);
        }
    }

    /**
     * 二叉查找树后序遍历
     * @return com.freedom.datastructure.linear.Queue<Key> 遍历完成的key队列
     */
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    /**
     * 二叉查找树后序遍历子树
     * @param node 子树根节点
     * @param keys 存储key值队列
     */
    private void afterErgodic(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            afterErgodic(node.left, keys);
        }
        if (node.right != null) {
            afterErgodic(node.right, keys);
        }
        keys.enqueue(node.key);
    }

    /**
     * 二叉查找树层序遍历
     * @return com.freedom.datastructure.linear.Queue<Key> 遍历完成的key队列
     */
    public Queue<Key> layerErgodic() {
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.dequeue();
            keys.enqueue(node.key);
            if (node.left != null) {
                nodes.enqueue(node.left);
            }
            if (node.right != null) {
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }

    /**
     * 获取二叉查找树最大深度
     * @return int 最大深度值
     */
    public int getMaxDepth() {
        return getMaxDepth(root);
    }

    /**
     * 获取二叉查找树子树最大深度
     * @param node 子树根节点
     * @return int 最大深度
     */
    private int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        //左右子树最大深度
        int maxL = 0;
        int maxR = 0;
        if (node.left != null) {
            maxL = getMaxDepth(node.left);
        }
        if (node.right != null) {
            maxR = getMaxDepth(node.right);
        }
        //对比返回左右子树中最大深度并+1根节点深度
        return maxL > maxR ? maxL + 1 : maxR + 1;
    }

    /** 树叶子节点 */
    private class Node {
        /** 树叶子key */
        public Key key;
        /** 树叶子value */
        public Value value;
        /** 树叶子左子节点 */
        public Node left;
        /** 树叶子右子节点 */
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
