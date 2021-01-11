package com.cmbk.algo;

import java.util.ArrayList;
import java.util.List;

public class MyAVL<E extends Comparable<E>> {
    class Node {
        private final E element;
        int height = 1;
        private Node right;
        private Node left;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node root;

    public int height(Node node) {
        return node == null ? 0 : node.height;
    }

    Node rightRotate(Node node) {
        Node left = node.left;
        Node right = left.right;
        left.right = node;
        node.left = right;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        left.height = Math.max(height(left.left), height(left.right)) + 1;
        return node;
    }

    Node leftRotate(Node node) {
        Node right = node.right;
        Node left = right.left;
        right.left = node;
        node.right = left;
        right.height = Math.max(height(right.right), height(right.left)) + 1;
        node.height = Math.max(height(node.right), height(node.left)) + 1;
        return node;
    }

    public int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    public Node insert(Node node, E element) {
        //1. perform the normal BST insertion
        if (node == null) return new Node(element);
        if (element.compareTo(node.element) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = insert(node.right, element);
        } else {
            return node;
        }

        node.height = Math.max(height(node.right), height(node.left)) + 1;

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        //If the node becomes unbalanced, then there are 4 case
        //1. Left Left case
        if (balance > 1 && element.compareTo(node.left.element) < 0) {
            return rightRotate(node);
        }

        //2. Right Right case
        if (balance < -1 && element.compareTo(node.right.element) > 0) {
            return leftRotate(node);
        }

        //3. Left Right case
        if (balance > 1 && element.compareTo(node.left.element) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //4. Right Left case
        if (balance < -1 && element.compareTo(node.right.element) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */

        return node;
    }

    List<E> preOrder(Node node) {
        List<E> list = new ArrayList<>();
        if (node != null) {
            list.add(node.element);
            System.out.println(node.element);
            preOrder(node.left);
            preOrder(node.right);
        }
        return list;
    }

    public static void main(String[] args) {
        MyAVL<Integer> tree = new MyAVL();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : " + tree.preOrder(tree.root));
        tree.preOrder(tree.root);

        List<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(1);
        al.add(2);

        // This makes a call to remove(int) and
        // removes element 20.
        al.remove(1);

        // Now element 30 is moved one position back
        // So element 30 is removed this time
        al.remove(1);

        System.out.println("Modified ArrayList : " + al);
    }
}
