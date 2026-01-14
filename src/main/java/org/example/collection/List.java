package org.example.collection;

public abstract class List {
    protected final Integer[] items;
    protected int size;

    public List(int capacity) {
        items = new Integer[capacity];
        size = 0;
    }

    public abstract void addItem(Integer item);
    public abstract int indexOf(Integer item);

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
