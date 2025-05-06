package com.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbolprueba = new ArbolBinario();
        File file = new File("C:\\Users\\stuff\\OneDrive\\Escritorio\\UT4 - Francolino\\ut4_pd2\\clavesPrueba.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();

                int elemento = Integer.parseInt(linea.trim());

                arbolprueba.agregarNodo(elemento, "Nodo " + elemento); // El nombre del nodo es "Nodo " seguido del número
            }
            arbolprueba.imprimirArbol(); // Imprime el árbol después de agregar todos los nodos
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + e.getMessage());
        }
    }
}
/*
leer el archivo “claves_PRUEBA.txt”, y para cada clave crear un Nodo de Árbol Binario
de Búsqueda e insertarlo en el Árbol
c) Emitir y salvar a un archivo de texto los recorridos en preorden, inorden y postorden
*/