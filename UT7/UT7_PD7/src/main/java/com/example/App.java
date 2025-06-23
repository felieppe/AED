package com.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            LinkedList<TTarea> tareas = cargarTareas("src\\main\\java\\com\\example\\tareas.txt");
            LinkedList<TArista> aristas = cargarAristas("src\\main\\java\\com\\example\\precedencias.txt");

            TGrafoDirigido grafo = new TGrafoDirigido();
            for (TTarea tarea : tareas) {
                grafo.agregarTarea(tarea);
            }
            for (TArista arista : aristas) {
                grafo.agregarDependencia(arista);
            }

            LinkedList<String> orden = grafo.ordenParcial();
            grafo.listarTareas(orden);
            emitirArchivo("orden.txt", orden);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void emitirArchivo(String nombreArchivo, LinkedList<String> tareas) throws IOException {
        Path path = Paths.get(nombreArchivo);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String tarea : tareas) {
                writer.write(tarea);
                writer.newLine();
            }
        }
    }

    public static LinkedList<TTarea> cargarTareas(String archivo) throws IOException {
        LinkedList<TTarea> tareas = new LinkedList<>();
        List<String> lineas = Files.readAllLines(Paths.get(archivo));
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String codigo = partes[0].trim();
                double tiempo = Double.parseDouble(partes[1].trim());
                tareas.add(new TTarea(codigo, tiempo));
            } else {
                System.err.println("Línea mal formada: " + linea);
            }
        }
        return tareas;
    }
    

    public static LinkedList<TArista> cargarAristas(String archivo) throws IOException {
        LinkedList<TArista> aristas = new LinkedList<>();
        List<String> lineas = Files.readAllLines(Paths.get(archivo));
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                String origen = partes[0].trim();
                String destino = partes[1].trim();
                aristas.add(new TArista(origen, destino));
            } else {
                System.err.println("Línea mal formada: " + linea);
            }
        }
        return aristas;
    }
    
}
