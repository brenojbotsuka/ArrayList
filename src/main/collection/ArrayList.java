package main.collection;

import main.util.Order;
import main.util.SortAlgorithm;


public class ArrayList<T> {
    private final T[] items;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        items = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void addItem(T item) {
        if (isFull()) {
            return;
        }
        items[size] = item;
        size++;
    }

    public void addItem(T item, int position) throws IndexOutOfBoundsException {
        if (position < 0 || position > size) throw new IndexOutOfBoundsException();

        for (int cursor = size; cursor > position; cursor--) {
            items[cursor] = items[cursor - 1];
        }
        items[position] = item;
        size++;
    }

    public int indexOf(T item) {
        for (int position = 0; position < size; position++) {
            if (items[position].equals(item)) {
                return position;
            }
        }
        return -1;
    }

    public T getItem(int position) throws IndexOutOfBoundsException {
        if (position < 0 || position >= size) throw new IndexOutOfBoundsException();
        return items[position];
    }

    public void removeItem(int position) throws IndexOutOfBoundsException {
        if (position < 0 || position >= size) throw new IndexOutOfBoundsException();

        for (int cursor = position; cursor < size - 1; cursor++) {
            items[cursor] = items[cursor + 1];
        }
        items[size - 1] = null;
        size--;
    }

    public void sort(SortAlgorithm algorithm, Order order) {
        algorithm.execute(items, size, order);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= items.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayList {\n");
        sb.append("\titems: [");
        for (int postion = 0; postion < size; postion++) {
            sb.append(items[postion]);
            if (postion < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\n");
        sb.append(String.format("\tcapacity: %d\n", items.length));
        sb.append(String.format("\tsize: %d\n", size));
        sb.append("}");
        return sb.toString();
    }
}
