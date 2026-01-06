package main.collection;

public abstract class Heap {
    protected final Integer[] heap;
    protected int size;

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

        while (heap[current] > heap[parent(current)]) {
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

    protected int parent(int pos) { return (pos - 1) / 2; }
    protected int leftChild(int pos) { return (2 * pos) + 1; }
    protected int rightChild(int pos) { return (2 * pos) + 2; }

    protected void swap(int pos1, int pos2) {
        Integer tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    protected abstract void heapify(int pos);
}
