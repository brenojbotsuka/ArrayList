package org.example.util;

@FunctionalInterface
public interface SortAlgorithm {
    void execute(Integer[] array, int size, Order order);
}
