package com.cmbk.data.structure;

public class MyQueue2<E> {
    private final MyStack<E> stack1 = new MyStack();
    private final MyStack<E> stack2 = new MyStack<>();
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(E element) {
        stack1.push(element);
        size++;
    }

    public E dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }

    public E dequeue2() {
        return stack1.pop();
    }

    public void enqueue2(E element) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(element);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void enQueue(E element) {
        stack1.push(element);
    }

    public E deQueue3() {
        if (stack1.isEmpty() || stack1.size() == 1) {
            return stack1.pop();
        } else {
            E e = stack1.pop();
            E last = deQueue3();
            stack1.push(e);
            return last;
        }
    }

}
