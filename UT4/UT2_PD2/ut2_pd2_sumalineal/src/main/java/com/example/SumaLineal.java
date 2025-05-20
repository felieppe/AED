package com.example;
import java.util.ArrayList;

public class SumaLineal 
{
    public static void main( String[] args )
    {
        ArrayList<Integer> lista = new ArrayList<>(); // Declare and initialize the 'lista' variable
        lista.add(4);
        lista.add(3);
        lista.add(6);
        lista.add(2);
        lista.add(5);
        lista.add(-1);
        System.out.println(sumaLineal(lista, lista.size()));
    }
    

    public static int sumaLineal(ArrayList<Integer> lista, int n){
        if (n <= 0){
            return 0;
        } else if (n == 1){
            return lista.get(0);
        } else {
            return lista.get(n - 1) + sumaLineal(lista, n - 1);
        }
        
    }
}