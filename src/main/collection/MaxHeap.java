package main.collection;

public class MaxHeap {
    private final Integer[] heap;
    private int size;

    public MaxHeap(int capacity) {
        this.size = 0;
        this.heap = new Integer[capacity];
    }

    public MaxHeap(Integer[] array, int size) {
        this.size = size;
        this.heap = array;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void push(Integer element) {
        if (size >= heap.length) return;

        heap[size] = element;
        int current = size;
        size++;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer popMax() {
        Integer popped = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return popped;
    }

    public Integer peekMax() {
        if (size == 0) throw new IllegalStateException("Heap vazia");
        return heap[0];
    }

    private int parent(int pos) { return (pos - 1) / 2; }
    private int leftChild(int pos) { return (2 * pos) + 1; }
    private int rightChild(int pos) { return (2 * pos) + 2; }

    private void swap(int pos1, int pos2) {
        Integer tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    private void heapify(int pos) {
        int largest = pos;

        int left = leftChild(pos);
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        int right = rightChild(pos);
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != pos) {
            swap(pos, largest);
            heapify(largest);
        }
    }
}
