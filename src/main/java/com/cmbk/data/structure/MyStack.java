package com.cmbk.data.structure;

public class MyStack<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node top;
    private int size = 0;

    public E pop() {
        return top == null ? null : top.element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(E element) {
        Node node = new Node(element);
        if (isEmpty()) this.top = node;
        else {
            Node currentTop = this.top;
            this.top = node;
            this.top.next = currentTop;
        }
        size++;
    }

    public E peek() {
        Node currentTop = this.top;
        this.top = this.top.next;
        size--;
        return currentTop.element;
    }
}
