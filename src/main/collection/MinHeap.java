package main.collection;

public class MinHeap extends Heap {
    public MinHeap(int capacity) {
        super(capacity);
    }

    public MinHeap(Integer[] array, int size) {
        super(array, size);
    }

    @Override
    protected void heapify(int pos) {
        int smallest = pos;

        int left = leftChild(pos);
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        int right = rightChild(pos);
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != pos) {
            swap(pos, smallest);
            heapify(smallest);
        }
    }
}

