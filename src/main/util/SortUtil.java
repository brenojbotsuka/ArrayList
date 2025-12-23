package main.util;

public class SortUtil {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void bubbleSort(Object[] array, int size, Order order) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T left = (T) array[j];
                T right = (T) array[j + 1];
                if (compareValues(left.compareTo(right), order)) {
                    swapValues(array, j, j + 1);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void insertionSort(Object[] array, int size, Order order) {
        for (int i = 1; i < size; i++) {
            T key = (T) array[i];
            int j = i - 1;
            while (j >= 0) {
                T left = (T) array[j];
                if (compareValues(left.compareTo(key), order)) {
                    array[j + 1] = left;
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void selectionSort(Object[] array, int size, Order order) {
        for (int i = 0; i < size - 1; i++) {
            int selectedIdx = i;
            for (int j = i + 1; j < size; j++) {
                T left = (T) array[selectedIdx];
                T right = (T) array[j];
                if (compareValues(left.compareTo(right), order)) {
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

    @SuppressWarnings("unchecked")
    private static <T> void swapValues(Object[] array, int left, int right) {
        T temp = (T) array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
