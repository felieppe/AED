package com.felieppe;

public class Contador {
    private final int MAX_CONT = 50;
    private int incremento = 1, contador = 1;

    public Contador() {}

    public void mostrarContador() {
        while (contador <= MAX_CONT) {
            System.out.println(contador);
            contador += incremento;
        }
    }

    public void mostrarContadorDoWhile() {
        do {
            System.out.println(contador);
            contador = contador + incremento;
        } while (contador <= MAX_CONT);
    }

    public void mostrarContadorFor() {
        for (int contador = 1; contador <= MAX_CONT; contador = contador + incremento) {
            System.out.println(contador);
        }
    }
}
