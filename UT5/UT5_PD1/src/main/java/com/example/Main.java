package com.example;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del árbol genérico.
        TArbolGenerico organigramaUniversidad = new TArbolGenerico();

        // Insertar nodos en el árbol.
        organigramaUniversidad.insertar("RECTORÍA", "");
        organigramaUniversidad.insertar("VICERRECTORÍA ADMINISTRATIVA", "RECTORÍA");
        organigramaUniversidad.insertar("VICERRECTORÍA ACADÉMICA", "RECTORÍA");
        organigramaUniversidad.insertar("VICERRECTORÍA DEL MEDIO UNIVERSITARIO", "RECTORÍA");
        organigramaUniversidad.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORÍA ACADÉMICA");
        organigramaUniversidad.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORÍA ACADÉMICA");
        organigramaUniversidad.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "VICERRECTORÍA ACADÉMICA");
        organigramaUniversidad.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORÍA ACADÉMICA");
        organigramaUniversidad.insertar("DEPARTAMENTO DE INFORMÁTICA Y CIENCIAS DE LA COMPUTACIÓN", "FACULTAD DE CIENCIAS EMPRESARIALES");
        organigramaUniversidad.insertar("DEPARTAMENTO DE INGENIERÍA ELÉCTRICA", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        organigramaUniversidad.insertar("DEPARTAMENTO DE MATEMÁTICAS", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");

        // Listar el organigrama de manera indentada.
        System.out.println("Organigrama de la Universidad:");
        organigramaUniversidad.listarIndentado();
    }
}


