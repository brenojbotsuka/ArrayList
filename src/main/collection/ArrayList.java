package main.collection;

import main.util.Order;
import main.util.SortAlgorithm;
import java.lang.reflect.Array;
import java.util.Arrays;


public class ArrayList {
    private final Integer[] items;
    private int size;

    public ArrayList(int capacity) {
        items = new Integer[capacity];
        this.size = 0;
    }

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

    public int indexOf(Integer item) {
        for (int position = 0; position < size; position++) {
            if (items[position].equals(item)) {
                return position;
            }
        }
        return -1;
    }

    public Integer getItem(int position) throws IndexOutOfBoundsException {
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
        Integer[] arr = Arrays.copyOf(items, size());
        algorithm.execute(arr, order);
        if (size >= 0) System.arraycopy(arr, 0, items, 0, size);
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
