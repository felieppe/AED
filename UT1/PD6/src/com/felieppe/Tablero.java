package com.felieppe;

public class Tablero {
    private int[][] tablero;

    public Tablero(int size) {
        tablero = new int[size][size];
    }

    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
