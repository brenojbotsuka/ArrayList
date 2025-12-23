package main.util;

public class SortUtil {
    public static void bubbleSort(Integer[] array, Order order) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int cmp = array[j].compareTo(array[j + 1]);
                if ((order == Order.ASC && cmp > 0) || (order == Order.DESC && cmp < 0)) {
                    Integer temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(Integer[] array, Order order) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            Integer key = array[i];
            int j = i - 1;
            while (j >= 0) {
                int cmp = array[j].compareTo(key);
                if ((order == Order.ASC && cmp > 0) || (order == Order.DESC && cmp < 0)) {
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(Integer[] array, Order order) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int selectedIdx = i;
            for (int j = i + 1; j < n; j++) {
                int cmp = array[selectedIdx].compareTo(array[j]);
                if ((order == Order.ASC && cmp > 0) || (order == Order.DESC && cmp < 0)) {
                    selectedIdx = j;
                }
            }
            if (selectedIdx != i) {
                swapItems(array, selectedIdx, i);
            }
        }
    }

    private static void swapItems(Integer[] array, int left, int right) {
        Integer temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
