package com.example;

/**
 * Hello world!
 *
 */
public class Factorial 
{
    public static void main( String[] args )
    {
        try {
            System.out.println("El factorial de 0 es: " + (factorial(0)));
            System.out.println("El factorial de 4 es: " + (factorial(4)));
            System.out.println("El factorial de 5 es: " + (factorial(5)));
            System.out.println("El factorial de -1 es: " + (factorial(-1)));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int factorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("El número no debe ser negativo");
        }
        try{
            if ((n == 0) || (n == 1)){
                return 1;
            } else {
                return n * factorial(n-1);
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return n;
        
    }
}
