package main.util;

@FunctionalInterface
public interface SortAlgorithm {
    void execute(Object[] array, int size, Order order);
}
