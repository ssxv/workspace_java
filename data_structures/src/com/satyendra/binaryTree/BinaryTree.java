package com.satyendra.binaryTree;

/**
 * A tree whose elements have at most 2 children is called a binary tree.
 * Since each element in a binary tree can have only 2 children,
 * we typically name them the left and right child.
 * <p>
 * Created by Satyendra on 21/01/17.
 */
public class BinaryTree {

    Node root;
    int nodeCount;
    private static int preIndex = 0;

    public BinaryTree() {
        root = null;
        nodeCount = 0;
    }

    /**
     * construct binary tree from an array.
     *
     * @param data
     */
    public BinaryTree(int[] data) {
        root = makeBinaryTree(data, 0);
        nodeCount = data.length;
    }

    /**
     * construct binary tree from pre-order and in-order array.
     *
     * @param pre
     * @param in
     */
    public BinaryTree(int[] pre, int[] in) {
        root = buildTree(pre, in, 0, in.length - 1);
    }

    /**
     * build binary tree from pre-order and in-order array.
     *
     * @param pre
     * @param in
     * @param start
     * @param end
     * @return
     */
    private Node buildTree(int[] pre, int[] in, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(pre[preIndex++]);
        if (start == end) {
            return node;
        }
        int inIndex = findInIndex(in, start, end, node.data);
        node.left = buildTree(pre, in, start, inIndex - 1);
        node.right = buildTree(pre, in, inIndex + 1, end);
        return node;
    }

    private int findInIndex(int[] in, int start, int end, int key) {
        for (int i = start; i <= end; ++i) {
            if (in[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * build binary tree from an array.
     * level wise array format.
     * missing node is indicated by -1.
     *
     * @param data
     * @param pos
     * @return
     */
    private Node makeBinaryTree(int[] data, int pos) {
        Node node = null;
        if (data[pos] != -1) {
            node = new Node(data[pos]);
        }
        int l = left(pos);
        if (l < data.length) {
            node.left = makeBinaryTree(data, l);
        }
        int r = right(pos);
        if (r < data.length) {
            node.right = makeBinaryTree(data, r);
        }
        return node;
    }

    /**
     * method to get left child index.
     *
     * @param i
     * @return
     */
    private int left(int i) {
        return (2 * i + 1);
    }


    /**
     * method to get right child index.
     *
     * @param i
     * @return
     */
    private int right(int i) {
        return (2 * i + 2);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    /**
     * perform pre-order traversal.
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * perform in-order traversal.
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + ", ");
        inOrder(node.right);
    }

    /**
     * perform post-order traversal.
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + ", ");
    }

    public void levelOrder() {
        int height = height(root);
        for (int i = 1; i <= height; ++i) {
            levelOrder(root, i);
        }
    }

    /**
     * perform level-order traversal.
     *
     * @param node
     */
    private void levelOrder(Node node, int level) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.data + ", ");
        else if (level > 1) {
            levelOrder(node.left, level - 1);
            levelOrder(node.right, level - 1);
        }
    }

    /**
     * method to find the height from the given node.
     *
     * @param root
     * @return
     */
    private int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    /**
     * main method, to test binary tree.
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] pre = new int[]{1, 2, 4, 6, 7, 5, 3};
        int[] in = new int[]{6, 4, 7, 2, 5, 1, 3};
        BinaryTree tree = new BinaryTree(pre, in);
        tree.preOrder();
        tree.inOrder();
        tree.levelOrder();

    }
}
