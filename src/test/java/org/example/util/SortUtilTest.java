package org.example.util;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortUtilTest {

    @Test
    @DisplayName("BubbleSort: Deve ordenar de forma Crescente (ASC)")
    void deveOrdenarCrescente() {
        // Arrange (Preparar)
        Integer[] array = {5, 1, 4, 2, 8};
        Integer[] esperado = {1, 2, 4, 5, 8};

        // Act (Agir)
        SortUtil.bubbleSort(array, array.length, Order.ASC);

        // Assert (Verificar)
        assertArrayEquals(esperado, array, "O array deveria estar em ordem crescente");
    }

    @Test
    @DisplayName("BubbleSort: Deve ordenar de forma Decrescente (DESC)")
    void deveOrdenarDecrescente() {
        // Arrange
        Integer[] array = {5, 1, 4, 2, 8};
        Integer[] esperado = {8, 5, 4, 2, 1};

        // Act
        SortUtil.bubbleSort(array, array.length, Order.DESC);

        // Assert
        assertArrayEquals(esperado, array, "O array deveria estar em ordem decrescente");
    }

    @Test
    @DisplayName("BubbleSort: Deve respeitar o parâmetro size (ordenar apenas parte do array)")
    void deveRespeitarTamanhoInformado() {
        // Arrange: Vamos pedir para ordenar apenas os 3 primeiros elementos
        Integer[] array = {10, 5, 2, 50, 40};
        // O esperado é que os 3 primeiros fiquem em ordem (2, 5, 10) e o resto permaneça igual
        Integer[] esperado = {2, 5, 10, 50, 40};

        // Act
        SortUtil.bubbleSort(array, 3, Order.ASC);

        // Assert
        assertArrayEquals(esperado, array);
    }

    @Test
    @DisplayName("BubbleSort: Deve funcionar com array de um único elemento")
    void deveFuncionarComElementoUnico() {
        Integer[] array = {10};
        Integer[] esperado = {10};

        SortUtil.bubbleSort(array, 1, Order.ASC);

        assertArrayEquals(esperado, array);
    }
}