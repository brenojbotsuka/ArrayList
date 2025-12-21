package main;

import main.collection.ArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando ArrayList\n");
        ArrayList list = new ArrayList(5);
        System.out.println(list);
        System.out.println("---");

        System.out.println("Adicionando itens no ArrayList\n");
        list.addItem(42);
        list.addItem(7);
        System.out.println(list);
        System.out.println("---");

        System.out.println("Adicionando itens no ArrayList até ficar cheio\n");
        Random random = new Random();
        while (!list.isFull()) {
            int item = random.nextInt(0, 100);
            list.addItem(item);
            System.out.println(list);
        }
        System.out.println("---");

        System.out.println("Consultando itens no ArrayList\n");
        for (int index = 0; index < list.size(); index++) {
            System.out.printf("Item[%d]: %d%n", index, list.getItem(index));
        }
        try {
            System.out.println(list.getItem(list.size()));
        } catch (IndexOutOfBoundsException ex) {
            System.out.printf("Item[%d]: está fora dos limites de list\n", list.size());
        }

        Integer lastItem = list.getItem(list.size() - 1);
        System.out.println(list.indexOf(lastItem));

        System.out.println(list.indexOf(42));
        System.out.println(list.indexOf(7));
        System.out.println(list.indexOf(101));
        System.out.println("---");
    }
}
