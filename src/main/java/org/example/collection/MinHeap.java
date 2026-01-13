package org.example.collection;

public class MinHeap extends Heap {
    public MinHeap(int capacity) {
        super(capacity);
    }

    public MinHeap(Integer[] array, int size) {
        super(array, size);
    }

    @Override
    protected boolean compare(Integer x1, Integer x2) {
        return x1 < x2;
    }
}

