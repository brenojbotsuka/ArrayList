package org.example.collection;

import org.example.model.Order;
import org.example.util.SortAlgorithm;


public class ArrayList extends List {
    public ArrayList(int capacity) {
        super(capacity);
    }

    @Override
    public void addItem(Integer item) {
        if (isFull()) {
            return;
        }
        items[size] = item;
        size++;
    }

    public void addItem(Integer item, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > size) throw new IndexOutOfBoundsException();

        for (int cursor = size; cursor > position; cursor--) {
            items[cursor] = items[cursor - 1];
        }
        items[position] = item;
        size++;
    }

    @Override
    public int indexOf(Integer item) {
        for (int position = 0; position < size; position++) {
            if (items[position].equals(item)) {
                return position;
            }
        }
        return -1;
    }

    public void sort(SortAlgorithm algorithm, Order order) {
        algorithm.execute(items, size, order);
    }
}
