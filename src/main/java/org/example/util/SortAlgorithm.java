package org.example.util;

import org.example.model.Order;

@FunctionalInterface
public interface SortAlgorithm {
    void execute(Integer[] array, int size, Order order);
}
