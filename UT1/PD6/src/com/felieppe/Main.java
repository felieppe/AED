package com.felieppe;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void leerEntradaArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            int entero = Integer.parseInt(br.readLine());
            double flotante = Double.parseDouble(br.readLine());
            String cadena = br.readLine();

            System.out.println("El entero leído es: " + entero);
            System.out.println("El número de punto flotante es: " + flotante);
            System.out.println("La cadena leída es: \"" + cadena + "\"");
            System.out.println("¡Hola " + cadena + "! La suma de " + entero + " y " + flotante + " es " + (entero + flotante) + ".");
            System.out.println("La división entera de " + flotante + " y " + entero + " es " + ((int) (flotante / entero)) + " y su resto es " + (flotante % entero) + ".");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: El archivo contiene datos con formato incorrecto.");
        }
    }

    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el radio de la circunferencia: ");
        double radio = scanner.nextDouble();

        double area = Math.PI * Math.pow(radio, 2);
        double perimetro = 2 * Math.PI * radio;

        System.out.println("El área de la circunferencia es: " + area);
        System.out.println("El perímetro de la circunferencia es: " + perimetro);

        scanner.close();
    }

    public static void transformarT9Texto(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/salida.txt"))) {

            StringBuilder textoInvertido = new StringBuilder();
            int caracter;
            while ((caracter = br.read()) != -1) {
                textoInvertido.insert(0, (char) caracter); // Inserta al principio para invertir
            }

            for (int i = 0; i < textoInvertido.length(); i++) {
                String digito = obtenerDigitoT9(textoInvertido.charAt(i));
                if (digito != null) {
                    bw.write(digito);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    private static String obtenerDigitoT9(char c) {
        c = Character.toLowerCase(c);

        if (c >= 'a' && c <= 'c') {
            return "2";
        } else if (c >= 'd' && c <= 'f') {
            return "3";
        } else if (c >= 'g' && c <= 'i') {
            return "4";
        } else if (c >= 'j' && c <= 'l') {
            return "5";
        } else if (c >= 'm' && c <= 'o') {
            return "6";
        } else if (c >= 'p' && c <= 's') {
            return "7";
        } else if (c >= 't' && c <= 'v') {
            return "8";
        } else if (c >= 'w' && c <= 'z') {
            return "9";
        } else if (c == ' ') {
            return "0";
        } else if (c == '.') {
            return "1";
        }

        return null;
    }

    public static int[] multiplicarVectores(int[] vector1, int[] vector2) {
        if (vector1 == null || vector2 == null || vector1.length != vector2.length) {
            return null;
        }

        int[] resultado = new int[vector1.length];

        for (int i = 0; i < vector1.length; i++) {
            resultado[i] = vector1[i] * vector2[i];
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Ejercicio 1
        Tablero ta = new Tablero(7);
        ta.imprimirTablero();

        // Ejercicio 2
        leerEntradaArchivo("datos.txt");
        leerEntradaStdin();

        // Ejercicio 3
        transformarT9Texto("entrada.txt");

        // Ejercicio 4
        int[] vec1 = {1,2,3};
        int[] vec2 = {4,5,6};
        int[] res = multiplicarVectores(vec1, vec2);
        if (res != null) {
            for (int re : res) {
                System.out.print(re + " ");
            }
        } else {
            System.out.println("No se pueden multiplicar los vectores.");
        }

    }
}
