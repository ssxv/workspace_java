package com.satyendra.binarySearchTree;

/**
 * BinarySearchTree
 *
 * Created by Satyendra on 22/01/17.
 */
public class BinarySearchTree {

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int data) {
        root = new Node(data);
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * method to insert key in appropriate position
     *
     * @param node
     * @param data
     * @return
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (node.data > data) {
            node.left = insert(node.left, data);
        } else if (node.data < data) {
            node.right = insert(node.right, data);
        }
        return node;
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
     * method to preform pre-order traversal
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
     * method to perform in-order traversal
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
     * method to perform post-order traversal
     *
     * @param node
     */private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + ", ");
    }

    public void search(int data) {
        Node node = search(root, data);
        if (node == null) {
            System.out.println("Data not found !!");
        } else {
            System.out.println("Found " + node.data);
        }
    }

    /**
     * method to search a key
     *
     * @param node
     * @param data
     * @return
     */
    private Node search(Node node, int data) {
        if (node == null || node.data == data) {
            return node;
        }
        if (node.data > data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    /**
     * method to delete a node.
     *
     * @param node
     * @param data
     * @return
     */
    private Node delete(Node node, int data) {
        if (node == null) {
            return node;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // this node is to be deleted
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // if none of the child is null, get smallest value in the right subtree.
            node.data = minimumValue(node.right);
            // delete the smallest value in the right subtree.
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    /**
     * method to find the minimum value.
     *
     * @param node
     * @return
     */
    private int minimumValue(Node node) {
        int min = node.data;
        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    public void minimumValue() {
        System.out.println(minimumValue(root));
    }

    /**
     * method to find the lowest common ancestor of two elements
     *
     * @param element1
     * @param element2
     */
    public void lowestCommonAncestor(int element1, int element2) {
        Node node = root;
        while (node != null) {
            if (element1 < node.data && element2 < node.data) {
                node = node.left;
            } else if (element1 > node.data && element2 > node.data) {
                node = node.right;
            } else {
                break;
            }
        }
        System.out.println(node.data);
    }

    /**
     * main method, to test binary search tree.
     *
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(60);
        bst.insert(80);
        bst.insert(40);

        bst.inOrder();

        bst.minimumValue();

        bst.lowestCommonAncestor(20, 80);
    }
}
