package main.util;

@FunctionalInterface
public interface SortAlgorithm {
    void execute(Integer[] array, Order order);
}
