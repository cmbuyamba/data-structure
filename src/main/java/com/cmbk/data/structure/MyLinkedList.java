package com.cmbk.data.structure;

public class MyLinkedList<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E get(int index) {
        int i = 0;
        while (head != null) {
            if (i == index) {
                return head.element;
            }
            i++;
            head = head.next;
        }
        return null;
    }

    public int getIndexOf(E value) {
        int i = 0;
        while (head != null) {
            if (value.equals(head.element)) {
                return i;
            }
            i++;
            head = head.next;
        }
        return -1;
    }

    public void add(E value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        size++;
    }

    public int remove(E value) {
        int i = -1;
        Node prev = null;
        Node current = head;

        if (current != null && current.element.equals(value)) {
            head = current.next;
            size--;
            return ++i;
        }

        while (current != null && !current.element.equals(value)) {
            i++;
            prev = current;
            current = current.next;
        }

        if (current != null && prev != null) {
            prev.next = current.next;
            size--;
            return i;
        }

        return -1;
    }

    public E remove(int index) {
        Node prev = null;
        Node current = head;

        if (index == 0 && current != null) {
            head = current.next;
            return current.element;
        }

        int counter = 0;

        while (current != null) {
            if (index != counter) {
                prev = current;
                current = current.next;
                counter++;
            } else {
                prev.next = current.next;
                return current.element;
            }
        }

        return null;
    }

    public void reverse() {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void reverseRecursion(Node node) {
        if (node == null || node.next == null) return;
        Node rest = node.next;
        reverseRecursion(rest);
        rest.next = node;
        node.next = null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        Node current = head;
        while (current != null) {
            result.append(current.element).append(" ");
            current = current.next;
        }
        return result.append("]").toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Celestin");
        myLinkedList.add("Kalubi");
        myLinkedList.add("Mbuyamba");
        myLinkedList.remove("s");
        System.out.println(myLinkedList);
    }
}
