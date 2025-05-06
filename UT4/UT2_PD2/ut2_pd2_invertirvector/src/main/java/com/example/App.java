package com.example;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        System.out.println(lista);
        invertirArray(lista, 0, lista.size() - 1);
        System.out.println(lista);
    }
    public static void invertirArray(ArrayList<Integer> A, int i, int j) {
        if (i < j) {
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
            invertirArray(A, i + 1, j - 1);
        }
    }
}
