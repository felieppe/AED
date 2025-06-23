package com.example;

public class Main extends SemestresMinimos{

    public static void main(String[] args) {
        int numCursos = 4;
        int[][] prerrequisitos = {{0, 1}, {1, 2}, {2, 3}};
        
        int resultado = encontrarSemestresMinimos(numCursos, prerrequisitos);
        
        if (resultado != -1) {
            System.out.println("El número mínimo de semestres necesarios es: " + resultado);
        } else {
            System.out.println("No es posible completar todos los cursos.");
        }

        int numComputadoras = 4;
        int[][] conexiones = {{0, 1}, {1, 2}, {0, 2}, {2, 3}};
        double[] probabilidades = {0.8, 0.9, 0.7, 0.6};
        int inicio = 0;
        
        double[] resultado1 = encontrarCaminosMasFiables(numComputadoras, conexiones, probabilidades, inicio);
        
        System.out.println("La probabilidad máxima de llegar a cada computadora desde la computadora inicial es:");
        for (int i = 0; i < resultado1.length; i++) {
            System.out.println("Computadora " + i + ": " + resultado1[i]);
        }
    }
}
