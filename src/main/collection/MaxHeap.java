package main.collection;

public class MaxHeap extends Heap {
    public MaxHeap(int capacity) {
        super(capacity);
    }

    public MaxHeap(Integer[] array, int size) {
        super(array, size);
    }

    protected void heapify(int pos) {
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
