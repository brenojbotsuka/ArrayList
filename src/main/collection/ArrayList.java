package main.collection;

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

    public int indexOf(Integer item) {
        for (int position = 0; position < size; position++) {
            if (items[position].equals(item)) {
                return position;
            }
        }
        return -1;
    }

    public Integer getItem(int positon) throws IndexOutOfBoundsException {
        if (positon < 0 || positon >= size) throw new IndexOutOfBoundsException();
        return items[positon];
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
