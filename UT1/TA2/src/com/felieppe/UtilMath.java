package com.felieppe;

public class UtilMath {
    public static int factorial(int num) {
        if (num < 0) { return -1; }
        if (num == 0) { return 1; }

        int resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }

    private static boolean isPrime(int numero) {
        if (numero <= 1) {
            return false;
        }
        int divisor = 2;
        while (divisor * divisor <= numero) {
            if (numero % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }

    private static int sumarPares(int limite) {
        int suma = 0;
        int numero = 0;
        while (numero <= limite) {
            suma += numero;
            numero += 2;
        }
        return suma;
    }

    private static int sumarImpares(int limite) {
        int suma = 0;
        int numero = 1;
        while (numero <= limite) {
            suma += numero;
            numero += 2;
        }
        return suma;
    }

    public static void verifyPrime(int num) {
        if (isPrime(num)) {
            System.out.println(num + " es primo.");
            System.out.println("Suma de números pares hasta " + num + ": " + sumarPares(num));
        } else {
            System.out.println(num + " no es primo.");
            System.out.println("Suma de números impares hasta " + num + ": " + sumarImpares(num));
        }
    }
}
