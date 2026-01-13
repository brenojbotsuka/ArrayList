package org.example.collection;

public class MaxHeap extends Heap {
    public MaxHeap(int capacity) {
        super(capacity);
    }

    public MaxHeap(Integer[] array, int size) {
        super(array, size);
    }

    @Override
    protected boolean compare(Integer x1, Integer x2) {
        return x1 > x2;
    }
}
