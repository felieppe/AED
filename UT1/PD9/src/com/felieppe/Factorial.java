package com.felieppe;

public class Factorial {
    private int n;

    public Factorial(int n) { this.n = n; }

    public int factorial() {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }

        // Caso base: factorial de 0 es 1
        if (n == 0) {
            return 1;
        }

        // Cálculo del factorial usando un bucle for
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }

        return resultado;
    }
}
