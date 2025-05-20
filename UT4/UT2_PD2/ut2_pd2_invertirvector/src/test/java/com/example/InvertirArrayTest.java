package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class InvertirArrayTest {

    @Test
    public void testInvertirArray() {
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        App.invertirArray(lista, 0, lista.size() - 1);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), lista);

        lista = new ArrayList<>(Arrays.asList(1));
        App.invertirArray(lista, 0, lista.size() - 1);
        assertEquals(Arrays.asList(1), lista);

        lista = new ArrayList<>();
        App.invertirArray(lista, 0, lista.size() - 1);
        assertEquals(new ArrayList<>(), lista);

        lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        App.invertirArray(lista, 1, 3);
        assertEquals(Arrays.asList(1, 4, 3, 2, 5), lista);

        final ArrayList<Integer> listaFinal = lista;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            App.invertirArray(listaFinal, -1, listaFinal.size() - 1);
        });
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            App.invertirArray(listaFinal, 0, listaFinal.size());
        });
    }
}