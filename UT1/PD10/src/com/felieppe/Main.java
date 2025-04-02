package com.felieppe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String archivo = "entrada.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            List<String> lineas = new ArrayList<>();
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            Random random = new Random();
            int indice1 = random.nextInt(lineas.size());
            int indice2 = random.nextInt(lineas.size());

            String[] palabras1 = lineas.get(indice1).split("\\s+");
            String[] palabras2 = lineas.get(indice2).split("\\s+");

            ContadorPalabras contador = new ContadorPalabras();
            String[] palabrasComunes = contador.palabrasComunes(palabras1, palabras2);

            System.out.println("Palabras comunes entre las líneas:");
            System.out.println("Línea 1: " + lineas.get(indice1));
            System.out.println("Línea 2: " + lineas.get(indice2));
            System.out.println("\nPalabras comunes:");
            for (String palabra : palabrasComunes) {
                System.out.println(palabra);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
