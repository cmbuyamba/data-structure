package com.cmbk.data.structure;

import java.util.*;

public class MyGraph<E> {
    private final Map<E, List<E>> map = new HashMap<>();

    public void addVertex(E vertex) {
        map.put(vertex, new ArrayList<>());
    }

    public void addEdge(E source, E destination, boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    void BFS(E element) {

        Map<E, Boolean> visited = new HashMap<>();

        Queue<E> queue = new ArrayDeque<>();
        int i = 0;
        visited.put(element,true);
        queue.add(element);

        while (!queue.isEmpty()) {
            element = queue.poll();
            System.out.println("element = " + element);
            Iterator<E> iterator = map.get(element).listIterator();
            while (iterator.hasNext()){
                E e = iterator.next();
                if (!visited.get(element)){
                    visited.put(element,true);
                    queue.add(element);
                }
            }
        }

    }
}
