package org.example.collection;

public class SortedArrayList extends List {
    public SortedArrayList(int capacity) {
        super(capacity);
    }

    public void addItem(Integer item) {
        if (size >= items.length) {
            return;
        }
        int cursor;
        for (cursor = size - 1; cursor >= 0; cursor--) {
            if (item >= items[cursor]) {
                items[cursor+1] = item;
                break;
            }
            items[cursor+1] = items[cursor];
        }
        if (cursor == -1) {
            items[cursor+1] = item;
        }
        size++;
    }

    public int indexOf(Integer item) {
        int lowerBound = 0;
        int upperBound = size - 1;
        int count = 0;
        while (lowerBound <= upperBound) {
            int targetPosition = (lowerBound + upperBound) / 2;
            Integer target = items[targetPosition];

            if (target.equals(item)) {
                System.out.println("Total de Comparações antes de encontrar o valor: " + count);
                return targetPosition;
            }

            count++;
            if (target > item) {
                upperBound = targetPosition - 1;
            } else{
                lowerBound = targetPosition + 1;
            }
        }
        System.out.println("Total de Comparações antes de encontrar o valor: " + count);
        return -1;
    }
}
