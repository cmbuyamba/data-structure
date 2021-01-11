package com.cmbk.data.structure;

public class MyHashTable<K, V> {
    static class Node<K, V> {
        K key;
        V value;

        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //bucket used to store data
    private Node<K, V>[] data;
    private int dataCapacity;
    private int size;

    public MyHashTable() {
        data = new Node[dataCapacity = 10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getDataIndex(K key) {
        return key.hashCode() % dataCapacity;
    }

    public V get(K key) {
        //Find head of the chain
        int dataIndex = getDataIndex(key);
        Node<K, V> head = data[dataIndex];
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int index = getDataIndex(key);
        Node<K, V> element = data[index];
        //check if the key is already present
        while (element != null) {
            if (element.key.equals(key)) {
                element.value = value;
                return;
            }
            element = element.next;
        }

        element = data[index];
        Node<K, V> node = new Node<K, V>(key, value);
        node.next = element;
        data[index] = node;
        size++;

        if (1.0 * size / dataCapacity >= .7) {
            Node<K, V>[] temp = data;
            dataCapacity = dataCapacity * 2;
            data = new Node[dataCapacity];
            size = 0;
            for (Node<K, V> head : temp) {
                while (head != null) {
                    put(head.key, head.value);
                    head = head.next;
                }
            }
        }
    }

    public V remove(K key) {
        int index = getDataIndex(key);
        //getting the head of the chain
        Node<K, V> head = data[index];

        //search the key into the chain
        Node<K, V> prev = null;
        while (head != null) {
            //find the key
            if (head.key.equals(key)) break;
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        if (prev != null) prev.next = head.next;
        else data[index] = head.next;
        return head.value;
    }

    // Driver method to test Map class
    public static void main(String[] args)
    {
        MyHashTable<String, Integer> map = new MyHashTable<>();
        map.put("this",1 );
        map.put("coder",2 );
        map.put("this",4 );
        map.put("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.get("coder"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
