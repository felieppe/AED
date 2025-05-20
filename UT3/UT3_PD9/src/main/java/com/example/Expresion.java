package com.example;

import java.util.Stack;


public class Expresion 
{
    public static boolean verificar(String expresion) {
        Stack<Character> pila = new Stack<>();
    
        for(char c: expresion.toCharArray()) {
            if(isOpeningBracket(c)) {
                pila.push(c);
            } else if(isClosingBracket(c)) {
                if(!isValidClosingBracket(pila, c)) {
                    return false;
                }
            }
        }
    
        return pila.isEmpty();
    }
    
    private static boolean isOpeningBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private static boolean isClosingBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }
    
    private static boolean isValidClosingBracket(Stack<Character> pila, char c) {
        if(pila.isEmpty()) {
            return false;
        }
        char top = pila.pop();
        return (c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{');
    }

    public static void main(String[] args) {
        // Caso de prueba 1: una expresión bien formada
        System.out.println(verificar("{}")); // Debería imprimir true
    
        // Caso de prueba 2: una expresión mal formada con una llave de cierre sin abrir
        System.out.println(verificar("}")); // Debería imprimir false
    
        // Caso de prueba 3: una expresión mal formada con una llave de apertura sin cerrar
        System.out.println(verificar("{")); // Debería imprimir false
    
        // Caso de prueba 4: una expresión bien formada con múltiples pares de llaves
        System.out.println(verificar("{}{}")); // Debería imprimir true
    
        // Caso de prueba 5: una expresión mal formada con múltiples pares de llaves
        System.out.println(verificar("{}}{")); // Debería imprimir false
    
        // Caso de prueba 6: una expresión vacía
        System.out.println(verificar("")); // Debería imprimir true
    }
}
