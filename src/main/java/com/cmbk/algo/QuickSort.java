package com.cmbk.algo;

import java.util.Arrays;
import java.util.Random;

public class QuickSort<E extends Comparable<E>> {

    public void quickSort(E[] array, int low, int high) {
        if (low < high) {
            int pivot = pivot(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int pivot(E[] array, int low, int high) {
        int pivotIndex = new Random().nextInt(high - low) + low;
        E pivot = array[pivotIndex];
        int smaller = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i].compareTo(pivot) <= 0) {
                smaller++;
                swap(array, smaller, i);
            }
        }
        swap(array, smaller + 1, pivotIndex);
        return smaller + 1;
    }

    public static void main(String[] args) {
        QuickSort<Integer> sorter = new QuickSort<>();
        Integer[] list = {12, 5, 56, 22, -4, 200, 85};
        sorter.quickSort(list, 0, list.length - 1);
        System.out.println(Arrays.asList(list));
    }
}
