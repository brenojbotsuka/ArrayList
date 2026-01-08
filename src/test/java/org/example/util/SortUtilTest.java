package org.example.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortUtilTest {

    @Test
    @DisplayName("BubbleSort: Deve ordenar de forma Crescente (ASC)")
    void shouldSortAscending() {
        Integer[] array = {5, 1, 4, 2, 8};
        Integer[] expected = {1, 2, 4, 5, 8};

        SortUtil.bubbleSort(array, array.length, Order.ASC);

        assertArrayEquals(expected, array, "The array should be in ascending order");
    }

    @Test
    @DisplayName("BubbleSort: Deve ordenar de forma Decrescente (DESC)")
    void shouldSortDescending() {
        Integer[] array = {5, 1, 4, 2, 8};
        Integer[] expected = {8, 5, 4, 2, 1};

        SortUtil.bubbleSort(array, array.length, Order.DESC);

        assertArrayEquals(expected, array, "The array should be in descending order");
    }

    @Test
    @DisplayName("BubbleSort: Deve respeitar o parâmetro size (ordenar apenas parte do array)")
    void shouldRespectProvidedSize() {
        Integer[] array = {10, 5, 2, 50, 40};
        Integer[] expected = {2, 5, 10, 50, 40};

        SortUtil.bubbleSort(array, 3, Order.ASC);

        assertArrayEquals(expected, array);
    }

    @Test
    @DisplayName("BubbleSort: Deve funcionar com array de um único elemento")
    void shouldWorkWithSingleElement() {
        Integer[] array = {10};
        Integer[] expected = {10};

        SortUtil.bubbleSort(array, 1, Order.ASC);

        assertArrayEquals(expected, array);
    }

    @Test
    @DisplayName("BubbleSort: Deve funcionar com array de um único elemento")
    void shouldWorkWithEmptyList() {
        Integer[] array = {null, null, null, null};
        Integer[] expected = {null, null, null, null};

        SortUtil.bubbleSort(array, 0, Order.ASC);

        assertArrayEquals(expected, array);
    }
}