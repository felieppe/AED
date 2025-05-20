package com.example;

public class potencia 
{
    public static void main( String[] args )
    {
        System.out.println("La potencia de 2 a la 3 es: " + potencia(2,3));
        System.out.println("La potencia de 2 a la -3 es: " + potencia(2,-3));
        System.out.println("La potencia de 2 a la 0 es: " + potencia(2,0));
    }

    public static float potencia(int base, int exponente){
        if (exponente == 0){
            return 1;
        }else if(exponente < 0){
            return 1/potencia(base, -exponente);
        }else{
            return base * potencia(base, exponente - 1);
        }      
    }
}
