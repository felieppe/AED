package com.example;

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();
        
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\com\\example\\tareas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 2) {
                    System.out.println("Skipping line: " + linea);
                    continue;
                }
                try {
                    int id = Integer.parseInt(partes[1]);
                    String nombre = partes[0].trim();
                    grafo.agregarTarea(new Tarea(id, nombre));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\com\\example\\precedencias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 2) {
                    System.out.println("Skipping line: " + linea);
                    continue;
                }
                try {
                    String nombreTarea1 = partes[0].trim();
                    String nombreTarea2 = partes[1].trim();
                    int idTarea1 = obtenerIdTareaPorNombre(grafo, nombreTarea1);
                    int idTarea2 = obtenerIdTareaPorNombre(grafo, nombreTarea2);
                    grafo.agregarPrecedencia(idTarea1, idTarea2);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            List<Tarea> orden = grafo.ordenParcial();
            System.out.println("Orden de ejecución de las tareas:");
            for (Tarea tarea : orden) {
                System.out.println(tarea);
            }
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int obtenerIdTareaPorNombre(GrafoDirigido grafo, String nombreTarea) {
        for (Tarea tarea : grafo.getTareas()) {
            if (tarea.getNombre().equals(nombreTarea)) {
                return tarea.getId();
            }
        }
        throw new NoSuchElementException("Task not found: " + nombreTarea);
    }
}
