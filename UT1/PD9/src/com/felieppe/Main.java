package com.felieppe;

public class Main {
    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Ejercicio 1
        Factorial factorial = new Factorial(5);
        System.out.println(factorial.factorial());

        // Ejercicio 2
        long numero = 17;

        if (isPrime(numero)) {
            System.out.println(numero + " es un número primo.");
            long sumaPares = 0;
            long i = 0;
            while (i <= numero) {
                if (i % 2 == 0) {
                    sumaPares += i;
                }
                i++;
            }
            System.out.println("La suma de los números pares desde 0 hasta " + numero + " es: " + sumaPares);
        } else {
            System.out.println(numero + " no es un número primo.");
            long sumaImpares = 0;
            long i = 1;
            while (i <= numero) {
                if (i % 2 != 0) {
                    sumaImpares += i;
                }
                i++;
            }
            System.out.println("La suma de los números impares desde 0 hasta " + numero + " es: " + sumaImpares);
        }
    }
}