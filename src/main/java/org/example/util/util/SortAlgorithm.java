package org.example.util.util;

@FunctionalInterface
public interface SortAlgorithm {
    void execute(Integer[] array, int size, Order order);
}
