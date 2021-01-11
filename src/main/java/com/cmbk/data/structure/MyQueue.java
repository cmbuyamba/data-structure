package com.cmbk.data.structure;

public class MyQueue<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(E element) {
        Node node = new Node(element);
        if (isEmpty()) {
            this.first = node;
        } else {
            this.last.next = node;
        }
        this.last = node;
        size++;
    }

    public E dequeue() {
        if (!(isEmpty())) {
            Node currentFirst = this.first;
            this.first = this.first.next;
            size--;
            return currentFirst.element;
        }
        return null;
    }

    public E peek() {
        return this.first == null ? null : this.first.element;
    }
}
