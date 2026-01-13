package org.example.util;

import org.example.model.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortUtilTest {
    static Stream<Arguments> algorithmProvider() {
        return Stream.of(
                arguments("BubbleSort", (SortAlgorithm) SortUtil::bubbleSort),
                arguments("InsertionSort", (SortAlgorithm) SortUtil::insertionSort),
                arguments("SelectionSort", (SortAlgorithm) SortUtil::selectionSort),
                arguments("HeapSort", (SortAlgorithm) SortUtil::heapSort)
        );
    }

    @ParameterizedTest(name = "{0}: Deve ordenar de forma Crescente (ASC)")
    @MethodSource("algorithmProvider")
    void shouldSortAscending(String name, SortAlgorithm algorithm) {
        Integer[] array = {5, 1, 4, 2, 8};
        Integer[] expected = {1, 2, 4, 5, 8};

        algorithm.execute(array, array.length, Order.ASC);

        assertArrayEquals(expected, array, name + " failed: The array should be in ascending order");
    }

    @ParameterizedTest(name = "{0}: Deve ordenar de forma Decrescente (DESC)")
    @MethodSource("algorithmProvider")
    void shouldSortDescending(String name, SortAlgorithm algorithm) {
        Integer[] array = {5, 1, 4, 2, 8};
        Integer[] expected = {8, 5, 4, 2, 1};

        algorithm.execute(array, array.length, Order.DESC);

        assertArrayEquals(expected, array, name + " failed: The array should be in descending order");
    }

    @ParameterizedTest(name = "{0}: Deve respeitar o parâmetro size (ordenar apenas parte do array)")
    @MethodSource("algorithmProvider")
    void shouldRespectProvidedSize(String name, SortAlgorithm algorithm) {
        Integer[] array = {10, 5, 2, 50, 40};
        Integer[] expected = {2, 5, 10, 50, 40};

        algorithm.execute(array, 3, Order.ASC);

        assertArrayEquals(expected, array);
    }

    @ParameterizedTest(name = "{0}: Deve funcionar com array de um único elemento")
    @MethodSource("algorithmProvider")
    void shouldWorkWithSingleElement(String name, SortAlgorithm algorithm) {
        Integer[] array = {10};
        Integer[] expected = {10};

        algorithm.execute(array, 1, Order.ASC);

        assertArrayEquals(expected, array);
    }

    @ParameterizedTest(name = "{0}: Deve funcionar com array vazio")
    @MethodSource("algorithmProvider")
    void shouldWorkWithEmptyList(String name, SortAlgorithm algorithm) {
        Integer[] array = {null, null, null, null};
        Integer[] expected = {null, null, null, null};

        algorithm.execute(array, 0, Order.ASC);

        assertArrayEquals(expected, array);
    }
}