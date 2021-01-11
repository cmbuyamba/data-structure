package com.cmbk.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort<E extends Comparable<E>> {

    public E[] mergeSort(E[] list) {

        E[][] partitions = partition(list);

        E[] left = partitions[0];
        if (left.length > 1) {
            left = mergeSort(left);
        }

        E[] right = partitions[1];
        if (right.length > 1) {
            right = mergeSort(right);
        }

        return merge(left, right);

    }

    private E[][] partition(E[] list) {
        int size = list.length;
        E[] left = (E[]) new Object[size / 2 + size % 2];
        E[] right = (E[]) new Object[size / 2];
        IntStream.range(0, (size / 2 + size % 2)).forEach(i -> left[i] = list[i]);
        IntStream.range(size / 2, list.length).forEach(i -> right[i] = list[i]);
        E[][] result = (E[][]) new Object[2];
        result[0] = left;
        result[1] = right;
        return result;
    }

    private E[] merge(E[] left, E[] right) {
        E[] result = (E[]) new Object[left.length + right.length];
        int i = 0;
        while (i < left.length && i < right.length) {
            if (left[i].compareTo(right[i]) <= 0) {
                result[i] = left[i];
            } else {
                result[i] = right[i];
            }
            i++;
        }

        int l = i, r = i;

        while (l < left.length) {
            result[i] = left[i];
            l++;
        }

        while (r < right.length) {
            result[i] = right[i];
            r++;
        }

        return result;
    }

    public static void main(String[] args) {
        MergeSort<Integer> sorter = new MergeSort<>();
        Integer[] list = {12, 5, 56, 22, -4, 200, 85};
        System.out.println(Arrays.toString(sorter.mergeSort(list)));
    }
}
