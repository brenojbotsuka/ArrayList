package org.example.collection;

public abstract class Heap {
    private final Integer[] heap;
    private int size;

    public Heap(int capacity) {
        this.size = 0;
        this.heap = new Integer[capacity];
    }

    public Heap(Integer[] array, int size) {
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

        while (compare(heap[current], heap[parent(current)])) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer pop() {
        Integer popped = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return popped;
    }

    public Integer peek() {
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
        int moreRelevant = pos;

        int left = leftChild(pos);
        if (left < size && compare(heap[left], heap[moreRelevant])) {
            moreRelevant = left;
        }
        int right = rightChild(pos);
        if (right < size && compare(heap[right], heap[moreRelevant])) {
            moreRelevant = right;
        }
        if (moreRelevant != pos) {
            swap(pos, moreRelevant);
            heapify(moreRelevant);
        }
    }

    protected abstract boolean compare(Integer x1, Integer x2);
}
