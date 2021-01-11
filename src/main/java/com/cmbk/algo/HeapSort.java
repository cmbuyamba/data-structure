package com.cmbk.algo;

import java.util.Arrays;

public class HeapSort<E extends Comparable<E>> {
    private void heapify(E[] array, int index) {
        int l = left(index);
               int r = right(index);
                int largest;

        largest = l < array.length && array[l].compareTo(array[index]) > 0 ? l : index;

        if (r < array.length && array[r].compareTo(array[largest]) > 0) largest = r;

        if (largest != index) {
            swap(array, largest, index);
            heapify(array, largest);
        }
    }

    private void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void buildHeap(E[] array) {
        for (int i = (array.length / 2); i >= 0; i--) {
            heapify(array, i);
        }
    }

    public void sort(E[] array) {
        buildHeap(array);
        int currentLength = array.length - 1;
        for (int i = currentLength; i > 1; i--) {
            swap(array, i, 0);
            currentLength--;
            heapify(array, 0);
        }
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    public static void main(String[] args) {
        Integer[] list = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.sort(list);
        System.out.println(Arrays.toString((list)));
    }
}
