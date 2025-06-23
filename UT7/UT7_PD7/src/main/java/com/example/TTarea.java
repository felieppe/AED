package com.example;

public class TTarea {
    private String codigo;
    private double tiempo;

    public TTarea(String codigo, double tiempo) {
        this.codigo = codigo;
        this.tiempo = tiempo;
    }

    public double getTiempo() {
        return tiempo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo + " [" + tiempo + " horas]";
    }
}
