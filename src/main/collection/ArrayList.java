package main.collection;

public class ArrayList {
    private Integer[] items;
    private int size;

    public ArrayList(int capacity) {
        items = new Integer[capacity];
        this.size = 0;
    }

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
