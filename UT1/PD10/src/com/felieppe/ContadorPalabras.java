package com.felieppe;

import java.util.ArrayList;
import java.util.List;

public class ContadorPalabras {

    public String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        List<String> resultado = new ArrayList<>();

        for (String palabra1 : palabras1) {
            for (String palabra2 : palabras2) {
                if (palabra1.equals(palabra2)) {
                    resultado.add(palabra1);
                    break; // Evitar duplicados si una palabra aparece varias veces en palabras2
                }
            }
        }

        // Convertir la lista a un array de Strings
        return resultado.toArray(new String[0]);
    }
}