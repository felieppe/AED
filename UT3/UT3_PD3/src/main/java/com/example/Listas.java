package com.example;
import java.util.ArrayList;
import java.util.List;

public class Listas
{
    public static List<Integer> crearLista(){
        List<Integer> listaelementos = new ArrayList<Integer>();
        for (int i = 0; i <= 5; i++){
            listaelementos.add(i);
        }
        return listaelementos;        
    }

    public static List<Integer> removerElemento(List<Integer> listaelementos) {
        listaelementos.remove(3);
        return listaelementos;
    }

    public static void main( String[] args )
    {
        List<Integer> lista = crearLista();
        System.out.println("Lista original: " + lista);  
        lista = removerElemento(lista);
        System.out.println("Lista después de eliminar el elemento: " + lista);
    }
}

/*
Lenguaje natural: Debemos de crear un programa que cree una lista y agregue elementos a la lista uno por uno,
para posteriormente imprimir esta lista al final. Luego debemos de eliminar un elemento de la lista dado su clave.

Precondiciones:
- i debe de ser un número entero e igual a 0.

Postcondiciones:
- Devolver una lista con los elementos agregados.
- Imprimir la lista con los elementos cuando se agregan y cuando se borran.  

Seudocódigo:
    Algoritmo crearLista 
        Comienzo 
            lista = []
            Para i = 0 Hacer hasta i < 5
                lista.agregar(i)
                devolver lista
            Fin Para
            imprimir lista
            lista.eliminarPorValor(3)
            devolver lista
            imprimir lista
        Fin
*/