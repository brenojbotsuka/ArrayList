package org.example.util;

import org.example.collection.Heap;
import org.example.collection.MaxHeap;
import org.example.collection.MinHeap;

public class SortUtil {
    public static void heapSort(Integer[] array, int size, Order order) {
        Heap heap = order == Order.ASC ? new MaxHeap(array, size) : new MinHeap(array, size);
        for (int i = size -  1; i >= 0; i--) {
            array[i] = heap.pop();
        }
    }

    public static void bubbleSort(Integer[] array, int size, Order order) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (compareValues(array[j].compareTo(array[j + 1]), order)) {
                    swapValues(array, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(Integer[] array, int size, Order order) {
        for (int i = 1; i < size; i++) {
            Integer key = array[i];
            int j = i - 1;
            while (j >= 0) {
                if (compareValues(array[j].compareTo(key), order)) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(Integer[] array, int size, Order order) {
        for (int i = 0; i < size - 1; i++) {
            int selectedIdx = i;
            for (int j = i + 1; j < size; j++) {
                if (compareValues(array[selectedIdx].compareTo(array[j]), order)) {
                    selectedIdx = j;
                }
            }
            if (selectedIdx != i) {
                swapValues(array, selectedIdx, i);
            }
        }
    }

    private static boolean compareValues(int compareResult, Order order) {
        return (order == Order.ASC && compareResult > 0) || (order == Order.DESC && compareResult < 0);
    }

    private static void swapValues(Integer[] array, int left, int right) {
        Integer temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
