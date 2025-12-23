package main.util;

@FunctionalInterface
public interface SortAlgorithm<T> {
    void execute(Object[] array, int size, Order order);
}
