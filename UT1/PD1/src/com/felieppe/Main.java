package com.felieppe;

public class Main {
    public static int recorrer (String cadena) {
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        return palabra.charAt(0);
    }

    public static String paraAString(int a) {
        Object x1 = new Integer(a);
        return x1.toString();
    }

    public static void main(String[] args) {
        // Ejercicio 3
        Multsuma ms = new Multsuma();
        double result = ms.multsuma(1.0, 2.0, 3.0);

        System.out.println(result);

        // Ejercicio 4
        Alumno al = new Alumno();
        System.out.println(al.getNombreAdmiracion());

        System.out.println(recorrer("Hola mundo"));
        System.out.println(getValor());
        System.out.println(getPrimerCaracter("Caracter"));
        System.out.println(paraAString(10));

        // Ejercicio 5
        Contador c = new Contador();
        c.mostrarContadorFor();
    }
}
