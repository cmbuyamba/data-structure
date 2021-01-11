package com.cmbk.algo;

public class MyBinarySearchTree<E extends Comparable<E>> {
    class Node {
        private final E element;
        Node left, right;

        public Node(E element) {
            this.element = element;
            this.left = this.right = null;
        }

        public String toString() {
            return element.toString();
        }

        public void traverse(Node node) {
            if (node != null) {
                traverse(node.right);
                System.out.println(node);
                traverse(node.left);
            }
        }
    }

    private Node root;

    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void insert(E element) {

        Node newNode = new Node(element);

        if (root == null || element.compareTo(root.element) == 0) {
            root = newNode;
            size = 1;
            return;
        }

        Node currentNode = this.root;

        while (true) {
            if (element.compareTo(currentNode.element) < 0) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    size++;
                    return;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    size++;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public void traverse() {
        if (root != null) {
            root.traverse(root);
        }
    }

    public Node lookup(E element) {
        Node node = root;
        while (node != null && element.compareTo(node.element) != 0) {
            if (element.compareTo(node.element) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public boolean lookupRecursion(E element, Node node) {

        if (node == null) {
            return false;
        }

        if (node.element.compareTo(element) == 0) {
            return true;
        }

        if (element.compareTo(node.element) < 0) {
            node = node.left;
        } else {
            node = node.right;
        }

        return lookupRecursion(element, node);
    }

    public static void main(String[] args) {
        MyBinarySearchTree<String> binarySearchTree = new MyBinarySearchTree();
        binarySearchTree.insert("2");
        binarySearchTree.insert("4");
        binarySearchTree.insert("0");
        binarySearchTree.insert("3");
        binarySearchTree.insert("5");
        binarySearchTree.insert("1");
        binarySearchTree.traverse();
        System.out.println(binarySearchTree.lookupRecursion("4", binarySearchTree.root));
    }
}
